function getBackground(movieName, movieId){
    switch (movieName){
        case 'Castle in the Sky':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/CastleInTheSky.jpg"); background-size: cover;')
            break;
        case 'Grave of the Fireflies':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/GraveOfTheFireflies.jpg"); background-size: cover;')
            break;
        case 'My Neighbor Totoro':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/MyNeighborTotoro.jpg"); background-size: cover;')
            break;
        case 'Kiki\'s Delivery Service':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/KikisDeliveryService.jpg"); background-size: cover;')
            break;
        case 'Only Yesterday':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/OnlyYesterday.jpg"); background-size: cover;')
            break;
        case 'Porco Rosso':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/PorcoRosso.jpg"); background-size: cover;')
            break;
        case 'Pom Poko':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/PomPoko.jpg"); background-size: cover;')
            break;
        case 'Whisper of the Heart':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/WhisperOfTheHeart.jpg"); background-size: cover;')
            break;
        case 'Princess Mononoke':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/PrincessMononoke.jpg"); background-size: cover;')
            break;
        case 'My Neighbors the Yamadas':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/MyNeighborsTheYamadas.jpg"); background-size: cover;')
            break;
        case 'Spirited Away':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/SpiritedAway.jpg"); background-size: cover;')
            break;
        case 'The Cat Returns':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/TheCatReturns.jpg"); background-size: cover;')
            break;
        case 'Howl\'s Moving Castle':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/HowlsMovingCastle.jpg"); background-size: cover;')
            break;
        case 'Tales from Earthsea':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/TalesFromEarthsea.jpg"); background-size: cover;')
            break;
        case 'Ponyo':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/Ponyo.jpg"); background-size: cover;')
            break;
        case 'Arrietty':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/Arrietty.jpg"); background-size: cover;')
            break;
        case 'From Up on Poppy Hill':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/FromUpOnPoppyHill.jpg"); background-size: cover;')
            break;
        case 'The Wind Rises':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/TheWindRises.jpg"); background-size: cover;')
            break;
        case 'The Tale of the Princess Kaguya':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/TheTaleOfThePrincessKaguya.jpg"); background-size: cover;')
            break;
        case 'When Marnie Was There':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/WhenMarnieWasThere.jpg"); background-size: cover;')
            break;
        case 'The Red Turtle':
            document.getElementById(movieId).setAttribute('style', 'background-image: url("/images/TheRedTurtle.jpg"); background-size: cover;')
            break;
        default:
            console.log("Could not load thumbnail for: " + movieName);
    }
}

function lightMode(){
    let body = document.getElementById("indexBody");
    let icon = document.getElementById("lightmode");
    let logo = document.getElementById("logo");
    let allTds = document.getElementsByClassName("flip-card-back");

    for(let i = 0; i < allTds.length; i++){
        allTds.item(i).setAttribute("style", "background-color: white; color: black;")
    }

    logo.setAttribute("src", "/images/StudioGhibli.png")
    logo.setAttribute("style", "height: 420px; width: 950px;")
    icon.setAttribute("src", "/images/darkmode.png");
    icon.setAttribute("id", "darkmode");
    icon.setAttribute("onclick", "darkMode()");
    body.setAttribute("style", "background-color: white;");
    localStorage.setItem("lightmode", "true");
}

function darkMode(){
    let body = document.getElementById("indexBody");
    let icon = document.getElementById("darkmode");
    let logo = document.getElementById("logo");
    let allTds = document.getElementsByClassName("flip-card-back");

    for(let i = 0; i < allTds.length; i++){
        allTds.item(i).setAttribute("style", "background-color: #2a3236; color: white;")
    }
    logo.setAttribute("src", "/images/StudioGhibliWhite.png")
    logo.setAttribute("style", "height: auto; width: auto;")
    icon.setAttribute("src", "/images/lightmode.png");
    icon.setAttribute("id", "lightmode");
    icon.setAttribute("onclick", "lightMode()");
    body.setAttribute("style", "background-color: #121517;");
    localStorage.setItem("lightmode", "false");
}

function lightModeDetails(){
    let body = document.getElementById("details-body");
    let icon = document.getElementById("lightmode");
    let contentContainer = document.getElementsByClassName("flip-card-inner-details");
    for (let i = 0; i < contentContainer.length; i++) {
        contentContainer.item(i).setAttribute("style", "background-color: white;")
    }
    let content = document.getElementsByClassName("content");
    for (let i = 0; i < content.length; i++) {
        content.item(i).setAttribute("style", "color: black;")
    }
    icon.setAttribute("src", "/images/darkmode.png");
    icon.setAttribute("id", "darkmode");
    icon.setAttribute("onclick", "darkModeDetails()");
    body.setAttribute("style", "background-color: white;");
    localStorage.setItem("lightmode", "true");
}

function darkModeDetails(){
    let body = document.getElementById("details-body");
    let icon = document.getElementById("darkmode");
    let contentContainer = document.getElementsByClassName("flip-card-inner-details");
    for (let i = 0; i < contentContainer.length; i++) {
        contentContainer.item(i).setAttribute("style", "background-color: #2a3236;")
    }
    let content = document.getElementsByClassName("content");
    for (let i = 0; i < content.length; i++) {
        content.item(i).setAttribute("style", "color: white;")
    }
    icon.setAttribute("src", "/images/lightmode.png");
    icon.setAttribute("id", "lightmode");
    icon.setAttribute("onclick", "lightModeDetails()");
    body.setAttribute("style", "background-color: #121517;");
    localStorage.setItem("lightmode", "false");
}

function checkLightModeDetails(){
    if(localStorage.getItem("lightmode") === "true"){
        lightModeDetails();
    }
    else{
        darkModeDetails();
    }
}

function checkLightMode(){
    if(localStorage.getItem("lightmode") === "true"){
        lightMode();
    }
    else{
        darkMode();
    }
}