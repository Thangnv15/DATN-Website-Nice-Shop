const sideLinks = document.querySelectorAll('.sidebar .side-menu li a:not(.logout)');

sideLinks.forEach(item => {
    const li = item.parentElement;
    item.addEventListener('click', () => {
        sideLinks.forEach(i => {
            i.parentElement.classList.remove('active');
        })
        li.classList.add('active');
    })
});

const menuBar = document.querySelector('.content_index nav .bx.bx-menu');
const sideBar = document.querySelector('.sidebar');

menuBar.addEventListener('click', () => {
    sideBar.classList.toggle('close');
});

const searchBtn = document.querySelector('.content_index nav form .form-input button');
const searchBtnIcon = document.querySelector('.content_index nav form .form-input button .bx');
const searchForm = document.querySelector('.content_index nav form');

window.addEventListener('resize', () => {
    if (window.innerWidth < 768) {
        sideBar.classList.add('close');
    } else {
        sideBar.classList.remove('close');
    }
    if (window.innerWidth > 576) {
        // searchBtnIcon.classList.replace('bx-x', 'bx-search');
        searchForm.classList.remove('show');
    }
});

const toggler = document.getElementById('theme-toggle');

toggler.addEventListener('change', function () {
    if (this.checked) {
        document.body.classList.add('dark');
    } else {
        document.body.classList.remove('dark');
    }
});

// Lấy danh sách các mục con của "Product"
const productSubMenu = document.querySelector('.sub-menu');

// Lấy mục "Product"
const productMenuItem = document.querySelector('.sanpham');

// Bắt đầu ẩn mục con của "Product"
productSubMenu.style.display = 'none';

// Thêm sự kiện click vào mục "Product"
productMenuItem.addEventListener('click', () => {
    // Toggle hiển thị mục con của "Product"
    if (productSubMenu.style.display === 'none') {
        productSubMenu.style.display = 'block';
    } else {
        productSubMenu.style.display = 'none';
    }
});
myapp.config(function ($routeProvider,$locationProvider){
    $locationProvider.hashPrefix("");
    $routeProvider
        .when("/sanpham",{
            templateUrl:"sanpham.html",
            controller:"sanPham-ctrl"
        })
})