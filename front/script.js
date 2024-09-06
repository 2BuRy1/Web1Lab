function checkNumberValue(y) {
    if (y <= -3 || y >= 5) {
        return false;
    }
    return true;

}


function sendInfo(element) {
    const y = parseFloat(element.y.value);
    const x = parseInt(element.xSelection.value);
    const r = parseInt(element.Radius.value);
    if (isNaN(y) || !checkNumberValue(y)) {
        alert("Enter a valid number")
    }




}







function checkNumberValue(y) {
    if (y <= -3 || y >= 5) {
        return false;
    }
    return true;

}