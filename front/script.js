


function submitForm(event) {
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

    drawDote(xValue, yValue, rValue);





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
        console.log(data.status);
        console.log(data.time);

         }
     );



}


function checkValue(value) {
    if (-3 > value || value > 5) {
        return false;
    }
    return true;

}



function drawDote(xValue , yValue , rValue) {
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