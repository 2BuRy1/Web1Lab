function submitForm(event) {
    event.preventDefault();
    let xHTML = document.getElementById("xSelection").value;
    let yHTML = document.getElementById("ySelection").value;
    let rHTML = document.querySelector('input[type="radio"]:checked').value;
    if (isNaN(parseFloat(yHTML)) || !checkValue(parseFloat(yHTML)) || !rHTML) {
        return;
    }
    const yValue = parseFloat(yHTML);
    const xValue = parseFloat(xHTML);
    const rValue = parseFloat(rHTML);

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

    let responseData;

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