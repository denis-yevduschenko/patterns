/* Abstraction */

var Shape = function (color) {
    var color = color;

    this.setColor = function (_color) {
        color = _color;
    };

    this.getColor = function () {
        return color;
    };

    this.applyColor = function () {
        color.applyColor();
    };
};

/* RefinedAbstraction */

var Triangle = function (color) {
    var shape = new Shape(color);

    this.setColor = function (color) {
        shape.setColor(color);
    };

    this.getColor = function () {
        return shape.getColor();
    };

    this.applyColor = function () {
        console.log("Triangle filled with color ");
        shape.applyColor();
    };
};

/* RefinedAbstraction */

var Pentagon = function (color) {
    var shape = new Shape(color);

    this.setColor = function (color) {
        shape.setColor(color);
    };

    this.getColor = function () {
        return shape.getColor();
    };

    this.applyColor = function () {
        console.log("Pentagon filled with color ");
        shape.applyColor();
    };
};

/* Implementor */

var Color = function () {
    this.applyColor = function () {
        throw new Error("applyColor method is not implemented");
    };
};

/* ConcreteImplementor */

var RedColor = function () {
    this.applyColor = function () {
        console.log("red color");
    };
};

RedColor.prototype = new Color();
RedColor.prototype.constructor = RedColor;

/* ConcreteImplementor - GreenColor */

var GreenColor = function () {
    this.applyColor = function () {
        console.log("green color");
    };
};

GreenColor.prototype = new Color();
GreenColor.prototype.constructor = GreenColor;

/* testing... */

var Application = function () {
    this.run = function () {
        var triangle = new Triangle(new RedColor());
        var pentagon = new Pentagon(new GreenColor());

        triangle.applyColor();
        pentagon.applyColor();

        triangle.setColor(new GreenColor());
        pentagon.setColor(new RedColor());

        triangle.applyColor();
        pentagon.applyColor();
    };
};

var app = new Application();
app.run();
