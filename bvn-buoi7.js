// Tạo mảng todos (mockup data)
const API_URL = "http://localhost:8000/todos";
let todos = [];
// Hiển thị danh sách todo ra ngoài giao diện
const ul = document.querySelector("ul");
const inputTodo = document.querySelector("#input-todo");

const btnAdd = document.querySelector("#btn-add");
// Hiển thị danh sách todo
const renderTodos = (todos) => {
    if (todos.length === 0) {
        ul.innerHTML = "<li>Danh sách công việc trống</li>";
        return;
    }
    let html = "";
    todos.forEach(todo => 
        {
        html += `
            <li> 
            <input 
                    type="checkbox" 
                    ${todo.status ? "checked" : ""}
                    onchange="toggleStatus(${todo.id})"
                />
                <span class=${todo.status ? "active" : ""}>${todo.name}</span>
                <button>Edit</button>
              
                <button onclick="deleteTodo(${todo.id})">Delete</button>
            </li>
        `;
    });
    ul.innerHTML = html;
};
// Lấy danh sách todo từ server
const getAllTodos = async () => {
    try 
    {
        let res = await axios.get(API_URL); // Gọi API lấy danh sách todo từ server
        console.log(res);
        todos = res.data; // Gán dữ liệu từ server vào mảng todos
        renderTodos(todos); // Hiển thị danh sách todo ra ngoài giao diện
    } catch (error) {
        console.log(error);
    }
};
//thêm mới todo

btnAdd.addEventListener("click",async()=>{
    const name = inputTodo.Value.trim();
    if(!name){
        alert("Vui lòng nhập công việc!");
        return;
    }
    try{
        const newTodo = {name, status:false};
        const res = await axios.post(API_URL, newTodo);
        
        todos.push(res.data);
        renderTodos(todos);
        inputTodo.Value="";
    }
    catch(error){
        console.log("lỗi khi thêm công việc:",error);
    }
});














//xóa todo
const deleteTodo = async (id) => 
    {
    const isConfirm = window.confirm("Bạn có chắc chắn muốn xóa công việc này không?");
    if (!isConfirm) return;
    try {
        // Xóa ở server
       
        await axios.delete(`${API_URL}/${id}`);
        // Xóa ở client
        const index = todos.findIndex((todo) => todo.id === id);
        todos = todos.filter((todo)=> todo.id!==id);
        renderTodos(todos);
    } 
    catch (error) {
        console.log("lỗi khi xóa",error);
    }
};



//cập nhật trạng thái (checkbox)
const toggleStatus = async (id) => {
    try {
        // Update status ở server
        const todo = todos.find(todo => todo.id === id);
        const updatedTodo = {...todo,status:!todo.status};

        await axios.put(`${API_URL}/${id}`,updatedTodo);
        // Update status ở client
        todo.status = !todo.status;
        renderTodos(todos);
    } catch (error) {
        console.log("lỗi khi cập nhật trạng thái:",error);
    }
};
//chỉnh sửa todo

const editTodo = async(id)=>{
    const todo = todos.find((todo)=>todo.id===id);
    const newName = prompt("nhập tên mới:",todo.name);
    if(newName===null||newName.trim()==="")return;
    try{
        const updatedTodo ={...todo, name:newName.trim()};
        await axios.put(`${API_URL}/${id}`,updatedTodo);
        todo.name = newName.trim();
        renderTodos(todos);
    }
    catch(error){
        console.log("lỗi khi chỉnh sửa:",error);
    }
};
//gọi API khi tải trang
getAllTodos();
 





