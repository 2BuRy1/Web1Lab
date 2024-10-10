document.getElementById("ySelection").addEventListener("input", function (e) {
    let value = e.target.value;

    if (!/^-?\d*\.?\d{0,10}$/.test(value)) {
        e.target.value = value.slice(0, -1);
    }
});


let checkboxes = document.querySelectorAll(".checkboxes");

checkboxes.forEach(function (checkbox) {
    checkbox.addEventListener('change', function (event) {
        checkboxes.forEach(function (cb) {
            if (cb !== event.target) {
                cb.checked = false;
            }
        });
    });
});


async function submit() {

    let xHTML = document.getElementById("xSelection");
    let yHTML = document.getElementById("ySelection");
    let rHTML = Array.from(checkboxes).find(i => i.checked);

    if (isNaN(parseFloat(yHTML.value)) || !checkValue(parseFloat(yHTML.value)) || !rHTML || !checkR(parseFloat(rHTML.value)) || !checkX(parseFloat(xHTML.value))) {
        return;
    }


    const xValue = parseInt(xHTML.value);
    const rValue = parseInt(rHTML.value);


    drawDot(xValue, yHTML.value, rValue);


    const requestContent = {
        method: "post",

        headers: {
            "content-type": "application/json",
        },

        body: JSON.stringify({
            x: xValue,
            y: yHTML.value,
            r: rValue
        })

    };


    const url = '/api/';


    fetch(url, requestContent).then(response => response.json())
        .then(data => appendData(data)).catch(err => console.error(err));


}


function checkValue(value) {

    if (-3 > value || value > 5) {
        return false;
    }
    return true;

}

function checkR(value) {

    let array = [1, 2, 3, 4, 5]
    for (let i = 0; i < array.length; i++) {
        if (array[i] === parseFloat(value)) {
            return true;
        }

    }
    return false;
}

function checkX(value) {

    let array = [-3, -2, -1, 0, 1, 2, 3, 4]
    for (let i = 0; i < array.length; i++) {
        if (array[i] === value) {
            return true;
        }
    }
    return false;


}


function appendData(item) {
    let body = document.getElementById("table_body");
    let thead = document.getElementById("table-header");
    let RequestStatus = document.querySelector("status")
    RequestStatus.innerHTML = '';

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


function drawDot(xValue, yValue, rValue) {
    const canvas = document.getElementById('canvas');
    const ctx = canvas.getContext('2d');

    let plotX = 2 * xValue / rValue * 50;

    let plotY = -2 * yValue / rValue * 50;
    ctx.beginPath();
    ctx.translate(canvas.width / 2, canvas.height / 2);
    ctx.arc(plotX, plotY, 5, 0, 2 * Math.PI);
    ctx.fillStyle = 'red';
    ctx.fill();
    ctx.resetTransform();
    ctx.closePath();

}

function badMessage() {
    let RequestStatus = document.querySelector("status")
    let statusText = document.createElement("h2");
    RequestStatus.classList.add('visible');
    RequestStatus.appendChild(statusText);

}


