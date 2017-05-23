var Universe;
(function () {
	var instance;
	Universe = function Universe() {
		if (instance) {
			return instance;
		}
		instance = this;
		//добавить остальную функциональность
		this.start_time = 0;
		this.bang = "Big";
	};
}());
// проверка
var uni = new Universe();
var uni2 = new Universe();
console.log(uni === uni2); // true
console.log(uni.constructor === Universe); // true
console.log(uni.bang);