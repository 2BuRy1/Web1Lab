const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');

const Xcanvas = canvas.width;
const Ycanvas = canvas.height;
const R = Math.min(Xcanvas, Ycanvas) / 4; // Радиус, равный четверти меньшей из сторон канваса

// Отрисовка сетки
const Xmove = 50;
const Ymove = 50;

    ctx.strokeStyle = '#5f9ea0';

    ctx.beginPath();
    for (let i = 0; i <= Xcanvas; i += Xmove) {
        ctx.moveTo(i, 0);
        ctx.lineTo(i, Ycanvas);
    }
    for (let i = 0; i <= Ycanvas; i += Ymove) {
        ctx.moveTo(0, i);
        ctx.lineTo(Xcanvas, i);
    }
    ctx.stroke();


    ctx.strokeStyle = '#000000';
    ctx.beginPath();
    ctx.moveTo(0, Ycanvas / 2);
    ctx.lineTo(Xcanvas, Ycanvas / 2);
    ctx.moveTo(Xcanvas / 2, 0);
    ctx.lineTo(Xcanvas / 2, Ycanvas);
    ctx.stroke();

    ctx.translate(Xcanvas / 2, Ycanvas / 2);

    ctx.fillStyle = '#5f9ea0';
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.arc(0, 0, R, Math.PI, 1.5 * Math.PI, false);
    ctx.closePath();
    ctx.fill();
    ctx.strokeStyle = '#000000';
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(R, 0);
    ctx.lineTo(0, R / 2);
    ctx.closePath();
    ctx.fill();
    ctx.strokeStyle = '#000000';
    ctx.stroke();

    ctx.beginPath();
    ctx.rect(0, -R, R / 2, R);
    ctx.closePath();
    ctx.fill();
    ctx.strokeStyle = '#000000';
    ctx.stroke();

    ctx.resetTransform();

    ctx.font = '16px Arial';
    ctx.fillStyle = '#000000';
    ctx.textAlign = 'center';

    ctx.fillText('-R', Xcanvas / 2 - R, Ycanvas / 2 + 20);
    ctx.fillText('-R/2', Xcanvas / 2 - R / 2, Ycanvas / 2 + 20);
    ctx.fillText('R/2', Xcanvas / 2 + R / 2, Ycanvas / 2 + 20);
    ctx.fillText('R', Xcanvas / 2 + R, Ycanvas / 2 + 20);

    ctx.fillText('R', Xcanvas / 2 - 20, Ycanvas / 2 - R + 5);
    ctx.fillText('R/2', Xcanvas / 2 - 20, Ycanvas / 2 - R / 2 + 5);
    ctx.fillText('-R/2', Xcanvas / 2 - 20, Ycanvas / 2 + R / 2 + 5);
    ctx.fillText('-R', Xcanvas / 2 - 20, Ycanvas / 2 + R + 5);


    ctx.fillText('Y', Xcanvas / 2 - 10, 20);
    ctx.fillText('X', Xcanvas - 20, Ycanvas / 2 + 20);




