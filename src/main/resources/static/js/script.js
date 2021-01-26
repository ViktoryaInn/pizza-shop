let modalWindow = document.querySelector('.modal__window');
let orderSendButton = document.querySelector('.orderForm-submit');
let closeButton = document.querySelector('.modal-close');

orderSendButton.addEventListener('click', (e) => {
    e.preventDefault();
    modalWindow.classList.toggle('modal__window--active');
});

closeButton.addEventListener('click', () => {
    modalWindow.classList.toggle('modal__window--active');
});

window.addEventListener('click', (e) => {
    if(e.target == modalWindow){
        modalWindow.classList.toggle('modal__window--active');
    }
});