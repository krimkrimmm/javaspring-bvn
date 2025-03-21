document.addEventListener("DOMContentLoaded", function () {
    // Xử lý sự kiện click vào poster hoặc nút xem trailer
    document.querySelectorAll(".watch-trailer-btn, .movie-poster").forEach(item => {
        item.addEventListener("click", function () {
            let trailerUrl = this.getAttribute("data-trailer");
            if (trailerUrl) {
                document.getElementById("trailerModal").classList.add("show");
                document.getElementById("trailerModal").style.display = "block";
                document.getElementById("trailerFrame").src = trailerUrl;
            }
        });
    });

    // Đóng modal khi bấm vào nút đóng
    document.querySelector(".close-modal").addEventListener("click", function () {
        document.getElementById("trailerModal").classList.remove("show");
        document.getElementById("trailerModal").style.display = "none";
        document.getElementById("trailerFrame").src = "";
    });
});
