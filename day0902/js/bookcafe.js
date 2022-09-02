


let stores = document.querySelectorAll('.store_area');
for (let i = 0; i < stores.length; i++){
    
    // stroes[i].onclick = 함수;
    // stores[i].addEventListener('click', 함수);
    
    stores[i].addEventListener('click', storeClick);
}

function storeClick() {
    let next = this.nextElementSibling;
    if (next.getAttribute("style") == "display:none;") {
        next.setAttribute("style", "display:block;");
    } else {
        next.setAttribute("style", "display:none;");
    }
}

document.getElementById('navLogin').onclick = login;

function login() {
    let userId = prompt('아이디 입력', 'ssafy');
    if (!userId) {
        alert('input Id !!!');
        return;
    }

    let userPw = prompt('패스워드 입력', '1234');
    if (!userPw) {
        alert('input pw !!!');
        return;
    }

    if (userId == 'ssafy' && userPw == '1234') {
        alert('login success');

        // document
        //     .getElementsByClassName('header_nav_menu_before')[0]
        //     .style.display = "none";
        //     document
        //     .getElementsByClassName('header_nav_menu_after')[0]
        //     .style.display = "block";

        document.querySelector('.header_nav_menu_before')
            .setAttribute('style', "display:none;");
        document.querySelector('.header_nav_menu_after')
            .setAttribute('style', "display:block");
        
        
        document.querySelector('.profile_img')
            .setAttribute('src', 'img/profile.png');

    } else {
        alert('login fail');
    }
}