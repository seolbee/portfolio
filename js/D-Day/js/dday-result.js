class Dday{
    constructor(){
        this.init();
    }

    init(){
        this.dateList = [];

        this.date = new Date();
        this.end = document.querySelector("#end");
        this.timer = document.querySelector("#timer");
        this.day = document.querySelector("#accent > span");
        this.end_class = new Date("2020/08/06 16:25:00");

        this.start_date = new Date("2020/08/14 00:00:00");
        this.end_date = new Date("2020/09/01 00:00:00");

        let date = Date.parse(this.start_date) - Date.now();
        let last_date = Date.parse(this.end_date) - Date.now();

        this.end.innerHTML = `D-${Math.ceil(last_date / (24 * 60 * 60 * 1000))}`;

        this.t = setInterval(this.setTime, 1000);
        this.day.innerHTML = `방학식까지 D-${Math.ceil(date / (24 * 60 * 60 * 1000))}`;
    }

    setTime = () => {
        let date = new Date();
        let hour = date.getHours();
        let minute = date.getMinutes();
        let second = date.getSeconds();

        let class_hour = this.end_class.getHours();
        let class_minute = this.end_class.getMinutes();
        let class_second = this.end_class.getSeconds();

        let current = hour * 3600 + minute * 60 + second;
        let class_time = class_hour * 3600 + class_minute * 60 + class_second;

        let time = class_time - current;

        if(time < 0){
            this.timer.innerHTML = `00:00:00`;
            clearInterval(this.t);
        }

        let res_hour = Math.floor(time / 3600);
        let res_minute = Math.floor(time % 3600 / 60);
        let res_second = Math.floor(time % 60);

        this.timer.innerHTML = `${this.format(res_hour)}:${this.format(res_minute)}:${this.format(res_second)}`;
    }

    format(value){
        value = "0" + value;
        return value.substr(value.length -2, value.length);
    }
}

let day = new Dday();