myapp.controller("sanPham-ctrl",function($scope,$http,$q,$route,SanPhamService){
    const openPopup = document.getElementById("openPopup");
    const closePopup = document.getElementById("closePopup");
    const productPopup = document.getElementById("productPopup");

    openPopup.addEventListener("click", function () {
        productPopup.style.display = "block";
    });

    closePopup.addEventListener("click", function () {
        productPopup.style.display = "none";
    });
})