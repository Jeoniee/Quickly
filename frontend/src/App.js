import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './App.css';  // 필요에 따라 CSS 파일 수정

function App() {
    const [location, setLocation] = useState(null);
    const [weather, setWeather] = useState(null);
    const [menu, setMenu] = useState('');

    useEffect(() => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(position => {
                setLocation({
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude
                });
            });
        } else {
            console.log("Geolocation is not available");
        }
    }, []);

    useEffect(() => {
        if (location) {
            const fetchWeather = async () => {
                const apiKey = process.env.REACT_APP_WEATHER_API_KEY;
                const url = 'https://api.openweathermap.org/data/2.5/weather?lat=' + location.latitude + '&lon=' + location.longitude + '&units=metric&appid=' + apiKey;
                try {
                    const response = await axios.get(url);
                    setWeather(response.data);
                } catch (error) {
                    console.error("Error fetching weather data", error);
                }
            };

            fetchWeather();
        }
    }, [location]);

    useEffect(() => {
        if (weather) {
            const fetchMenu = async () => {
                try {
                    const response = await axios.post('http://localhost:8080/api/recommend', {
                        location,
                        weather
                    });
                    setMenu(response.data);
                } catch (error) {
                    console.error("Error fetching menu", error);
                }
            };

            fetchMenu();
        }
    }, [weather]);

    const splitText = (text) => {
        return text.split('').map((char, index) => (
            <span key={index} className="jelly-text">{char}</span>
        ));
    };

    const letter = (text) => {
        return text.split(' ').map((word, index) => (
            word.split('').map((char, index2) => (
                <span key={index2} className="letter">{char}</span>
            ))
                .concat(<span key={index + '-space'}>&nbsp;</span>) // 공백 처리
        ));
    };

    return (
        <div>
            <h1>{letter("오늘 점심은 뭘 먹을까 ?")}</h1>
            {location ? (
                weather ? (
                    <div className="weather-container">
                        <div className="weather-info">
                            <p>현재 위치: {location.latitude}, {location.longitude}, {weather.name}</p>
                            <p>현재 날씨: {weather.main.temp}°C, {weather.weather[0].description}</p>
                        </div>
                        <div className="menu-container">
                            <h2>{splitText("이건 어때 ?")}</h2>
                            <p>{menu || '메뉴를 불러오는 중...'}</p>
                        </div>
                    </div>
                ) : (
                    <p className="loading-text">날씨 정보를 불러오는 중...</p>
                )
            ) : (
                <p className="loading-text">위치 정보를 불러오는 중...</p>
            )}
        </div>
    );
}

export default App;
