const btn = document.getElementById("btn");
const image = document.getElementById("image");
const select = document.getElementById("breed-list");
// Vừa load trang phải gọi API để render danh sách breed
async function getBreedList() {
    try 
    {
        let res = await axios.get("https://dog.ceo/api/breeds/list/all");
        renderBreed(res.data.message);
    } catch (error) {
        console.error("Error fetching breeds:", error);
    }
}
function renderBreed(breeds) {
    // Duyệt qua object breeds -> tạo thẻ option -> gắn vào DOM
    let options = Object.keys(breeds)
       
    .map(breed => `<option value="${breed}">${breed}</option>`)
        .join("");

    select.innerHTML = options;
}

// Khi click button, fetch ảnh của breed đã chọn
btn.addEventListener("click", async () => {
    let breed = select.value;
   
    if (!breed) return;

    try {
        let res = await axios.get(`https://dog.ceo/api/breed/${breed}/images/random`);
        image.src = res.data.message;
    } catch (error) {
        console.error("Error fetching image:", error);
    }
});

// Gọi API ngay khi load trang
getBreedList();
 