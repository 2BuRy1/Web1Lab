


async function submitForm(event) {
    event.preventDefault();
    let xHTML = document.getElementById("xSelection").value;
    let yHTML = document.getElementById("ySelection").value;
    let rHTML = document.querySelector('input[type="radio"]:checked').value;

    if (isNaN(parseFloat(yHTML)) || !checkValue(parseFloat(yHTML)) || !rHTML) {
        return;
    }
    const yValue = parseFloat(yHTML);
    const xValue = parseInt(xHTML);
    const rValue = parseInt(rHTML);

    drawDot(xValue, yValue, rValue);


    const requestContent = {
        "method": "post",

        "headers": {
            "content-type": "application/json",
        },

        "body": JSON.stringify({
            x: xValue,
            y: yValue,
            r: rValue
        })

    };

    const url = "/api/";


    fetch(url, requestContent).then(response => response.json()).then(data => {
        console.log(data.time);
        appendData(data, xValue, yValue, rValue);
        }
    );




}


function checkValue(value) {
    if (-3 > value || value > 5) {
        return false;
    }
    return true;

}


function appendData(item, x ,y ,r){
    let body = document.querySelector("table tbody");
    let thead = document.querySelector("table thead");
    let RequestStatus = document.querySelector("status")
    RequestStatus.innerHTML = '';

        const row = document.createElement("tr");

        const Xcell = document.createElement("td");
        Xcell.textContent = x;
        row.appendChild(Xcell);

        const Ycell = document.createElement("td");
        Ycell.textContent = y;
        row.appendChild(Ycell);

        const Rcell = document.createElement("td");
        Rcell.textContent = r;
        row.appendChild(Rcell);

        const status = document.createElement("td");

        item.status === true ? status.textContent = "Попадание" : status.textContent = "Промах";
        row.appendChild(status);

        const CurrentTime = document.createElement("td");
        CurrentTime.textContent = new Date().toLocaleDateString() + ":" + new Date().toLocaleTimeString();
        row.appendChild(CurrentTime);

        const SpentTime = document.createElement("td");
        SpentTime.textContent = item.time;
        row.appendChild(SpentTime);

        body.appendChild(row);
        thead.classList.add('visible');

        let statusText = document.createElement("h2");
        if(item.status){
            statusText.textContent = "Попадание";
            RequestStatus.style.color = "green";
        }
        else{
            statusText.textContent = "Промах"
            RequestStatus.style.color = "red";
        }
        RequestStatus.classList.add('visible');
        RequestStatus.appendChild(statusText);

}




function drawDot(xValue , yValue , rValue) {
    const canvas = document.getElementById('canvas');
    const ctx = canvas.getContext('2d');

    let plotX = 2 * xValue/ rValue * 50 ;

    let plotY = -2 * yValue / rValue * 50 ;
    ctx.beginPath();
    ctx.translate(canvas.width/2, canvas.height/2);
    ctx.arc(plotX, plotY, 5, 0, 2 * Math.PI);
    ctx.fillStyle = 'red';
    ctx.fill();
    ctx.resetTransform();
    ctx.closePath();


}