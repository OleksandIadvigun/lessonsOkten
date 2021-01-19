let text = document.getElementById('content');
text.innerText = "DASAS JKN KJH JKH ";
text.style.color = 'red';
console.log(text.innerText);

let ru = document.getElementById('rules');
ru.style.background = 'green';
console.log(ru.classList);

let fcrules = document.getElementsByClassName('fc_rules');
for (let fcrule of fcrules) {
    fcrule.style.background = `rgb(${Math.round(Math.random() * 255)}, ${Math.round(Math.random() * 255)}, ${Math.round(Math.random() * 255)})`;
}
console.log(fcrules);

