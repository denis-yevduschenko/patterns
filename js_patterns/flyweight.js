/* Flyweight interface */

var Shape = function () {
    this.draw = function () {};
};

/* ConcreteFlyweight */

var Circle = function (c) {
    var color = c,
        x,
        y,
        radius;

    this.setX = function (_x) {
        x = _x;
    };

    this.setY = function (_y) {
        y = _y;
    };

    this.setRadius = function (_radius) {
        radius = _radius;
    };

    this.draw = function () {
        console.log("Circle: Draw() [Color: " + color +
            ", x: " + x + ", y: " + y + ", radius: " + radius);
    };
};

Circle.prototype = new Shape();
Circle.prototype.constructor = Circle;

/* FlyweightFactory */
var ShapeFactory = (function () {
    var circleMap = {},
        getCircle = function (color) {
            var circle = circleMap[color] || null;
            if (circle === null) {
                circle = new Circle(color);
                circleMap[color] = circle;
                console.log("Creating circle of color: " + color);
            }
            return circle;
        },
        ShapeFactory = function () {};

    ShapeFactory.getCircle = getCircle;
    return ShapeFactory;
})();

// testing...

var Application = function () {
    var colors = ["Red", "Green", "Blue", "White", "Black", "Yellow"],

        getRandomColor = function () {
            return parseInt((Math.random() * colors.length), 10);
        },

        getRandomX = function () {
            return parseInt((Math.random() * 100), 10);
        },

        getRandomY = function () {
            return parseInt((Math.random() * 100), 10);
        };

        getRandomR = function () {
            return parseInt((Math.random() * 100), 10);
        };


    this.run = function () {
        for (var i = 0, circle; i < 20; ++i) {
            circle = ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(getRandomR());
            circle.draw();
        }
    };
};

var app = new Application();
app.run();