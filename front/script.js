document.getElementById("ySelection").addEventListener("input", function(e) {
    let value = e.target.value;

    // Разрешаем только числа и не более 10 знаков после запятой
    if (!/^\d*\.?\d{0,10}$/.test(value)) {
        e.target.value = value.slice(0, -1); // Удаляем последний символ
    }
});





async function submitForm(event) {
    event.preventDefault();
    let xHTML = document.getElementById("xSelection");
    let yHTML = document.getElementById("ySelection");
    let rHTML = document.querySelector('input[type="radio"]:checked');

    xHTML.classList.remove('error');

    yHTML.classList.remove('error');
    if (isNaN(parseFloat(yHTML.value)) || !checkValue(parseFloat(yHTML.value)) || !rHTML) {

        xHTML.classList.add('error');
        yHTML.classList.add('error');

        return;
    }

    const yValue = (yHTML.value);
    const xValue = parseInt(xHTML.value);
    const rValue = parseInt(rHTML.value);


    drawDot(xValue, yValue, rValue);


    const requestContent = {
        "method": "post",

        "headers": {
            "content-type": "application/json",
        },

        "body": JSON.stringify({
            x: xValue,
            y: yHTML.value,
            r: rValue
        })

    };




    const url = '/api/';


    fetch(url, requestContent).then(response => response.json()).then(data => {
        appendData(data);
        }
    );




}


function checkValue(value) {
    if (-3 > value || value > 5) {
        return false;
    }
    return true;

}


function appendData(item){
    let body = document.querySelector("table tbody");
    let thead = document.querySelector("table thead");
    let RequestStatus = document.querySelector("status")
    RequestStatus.innerHTML = '';
    if(item.x!==-228 && item.y!==-228 && item.r!==-228) {
         console.log(item.x.toString());

        const row = document.createElement("tr");

        const Xcell = document.createElement("td");
        Xcell.textContent = item.x;
        row.appendChild(Xcell);

        const Ycell = document.createElement("td");
        Ycell.textContent = item.y;
        row.appendChild(Ycell);

        const Rcell = document.createElement("td");
        Rcell.textContent = item.r;
        row.appendChild(Rcell);

        const status = document.createElement("td");

        item.status === true ? status.textContent = "Попадание" : status.textContent = "Промах";
        row.appendChild(status);

        const CurrentTime = document.createElement("td");
        CurrentTime.textContent = new Date().toLocaleTimeString();
        row.appendChild(CurrentTime);

        const SpentTime = document.createElement("td");
        SpentTime.textContent = item.time;
        row.appendChild(SpentTime);

        body.prepend(row);
        thead.classList.add('visible');

        let statusText = document.createElement("h2");
        if (item.status) {
            statusText.textContent = "Попадание";
            RequestStatus.style.color = "green";
        } else {
            statusText.textContent = "Промах"
            RequestStatus.style.color = "red";
        }
        RequestStatus.classList.add('visible');
        RequestStatus.appendChild(statusText);
    }
    else{
        let statusText = document.createElement("h2");
            statusText.textContent = "Некорректный запрос"
            RequestStatus.style.color = "red";

        RequestStatus.classList.add('visible');
        RequestStatus.appendChild(statusText);
    }

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


function showMessage(y){
    y.addEventListener("input", function(){



    })

}