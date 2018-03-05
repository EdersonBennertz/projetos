(function (cities) {

	const ajax = new XMLHttpRequest();
	const key = '1a373b6552ff69829380f1211101597a';
	const $formWeather = document.querySelector('[data-js="weather"]');
	const $city = document.querySelector('[data-js="weather-city"]');
	const $state = document.querySelector('[data-js="weather-state"]');
	const $titleToday = document.querySelector('[data-js="column-title-today"]');
	const $tempTodayNow = document.querySelector('[data-js="temp-toda-now"]');
	const $todaymin = document.querySelector('[data-js="column-today-min"]');
	const $todaymax = document.querySelector('[data-js="column-today-max"]');
	const $imgToday = document.querySelector('[data-js="today-img"]');
	const $suggestion = document.querySelector('[data-js="sugegstion"]');

	function init(){
		events();
	}

	function events() {
		$formWeather.addEventListener('submit', e => {
			e.preventDefault();
			const city = searchDataCity($city.value, $state.value);
			weatherAPI(city.lat, city.long);
		});
	}

	function weatherAPI(lat, long) {
		const url = 'http://api.openweathermap.org/data/2.5/forecast?lat=' + lat + '&lon=' + long + '&units=metric&appid=' + key;
		ajax.open('GET', url);
		ajax.send();
		ajax.addEventListener('readystatechange', handleWeather);
	}

	function handleWeather() {
		if (isRequestOK()) {
			fillWeatherData();
		}
	}

	function isRequestOK() {
		return ajax.status === 200 && ajax.readyState === 4;
	}

	function parseData() {
		var result;
		try {
			result = JSON.parse(ajax.responseText);
		} catch (e) {
			result = null;
		}
		return result;
	}

	function searchDataCity(city, state) {
		const cityFiltered = cities.filter(cit => {
			return cit.city.toLowerCase() === city.toLowerCase() && cit.state.toLowerCase() === state.toLowerCase();
		});
		return cityFiltered[0];
	}

	function fillWeatherData() {
		console.log(parseData());
		var data = parseData();
		var dateList = data.list[0];

		$titleToday.innerHTML = 'Previsão de hoje ' + dateNow();
		todayWeather(dateList.main);
		imgToday(dateList.weather[0].icon);
		suggestion(dateList.weather[0].main);

		fillWeatherForWeek(data.list);
	}

	function todayWeather() {
		$tempTodayNow.innerHTML = arguments[0].temp + 'º';
		$todaymin.innerHTML = 'Min: ' + arguments[0].temp_min + 'º';
		$todaymax.innerHTML = 'Max: ' + arguments[0].temp_max + 'º';
	}

	function imgToday() {
		$imgToday.setAttribute('src','http://openweathermap.org/img/w/'+arguments[0]+'.png');
	}

	function dateNow() {
		let date = new Date();
		return  date.getDate() + '/' + parseInt(date.getMonth()+1) + '/' + date.getFullYear()+
			 '  ' + date.getHours() + ':' + date.getMinutes();
	}

	function suggestion() {
		const weatherDescription = arguments[0];
		if (weatherDescription === 'Clear') {
			return $suggestion.innerHTML = 'O tempo está ótimo. Aproveite!';
		}
		return $suggestion.innerHTML = 'O tempo não está ensolarado. Cuidado!';
	}

	init();
})(window.cities);

