Quickly 는 사용자의 위치와 현재 날씨 정보를 제공 받아 OpenAi API 를 활용해 오늘 점심 메뉴를 추천해주는 사이트 입니다!

처음 프로그래밍을 접했을 때 만들었던 프로젝트를 새로운 언어와, ai를 연동하여 재구성 했습니다.😎

### ✔️ P**roject Structure**

---

```jsx
Quickly-app/
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com/
│   │   │   │   │   ├── example/
│   │   │   │   │   │   ├── MyLunchRecommendationAppApplication.java
│   │   │   │   │   │   ├── controller/
│   │   │   │   │   │   │   ├── RecommendationController.java
│   │   │   │   │   │   ├── service/
│   │   │   │   │   │   │   ├── ChatGPTService.java
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── ChatGPTRequest.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   ├── build.gradle
│   ├── settings.gradle
├── frontend/
│   ├── public/
│   │   ├── index.html
│   ├── src/
│   │   ├── App.js
│   │   ├── index.js
│   ├── package.json
├── gradlew
├── gradlew.bat
├── README.md
```

How to Start the Project 

---

**Back end Start**

```powershell
./gradlew bootRun
```

**Front end Start**

```jsx
npm start
```

### **💥 API Reference**

---

**OpenWeather Api**

https://openweathermap.org/

**OpenApi - ChatGPT**

https://platform.openai.com/playground/chat?models=gpt-3.5-turbo

**GeoLocation Api**

https://developers.google.com/maps/documentation/geolocation/overview?hl=ko

크롬으로 할 예정..
