var obj = document.getElementById("logo");
obj.onmouseover = function () {
    obj.setAttribute("src", "/static/clover-symbol-black.svg")
};
obj.onmouseleave = function () {
    obj.setAttribute("src", "/static/clover-symbol.svg")
};
var dialog = document.querySelector('dialog');
obj.onclick = function() {
    dialog.showModal();
    sound();
};
var tempobj = document.getElementById("shkiddi-close");
tempobj.onclick = function () {
    dialog.close();
};
tempobj.style.cursor = "pointer";
function sound() {
    let audio = new Audio(); // Создаём новый элемент Audio
    audio.src = '/static/ukraine.mp3'; // Указываем путь к звуку "клика"
    audio.autoplay = true; // Автоматически запускаем
}