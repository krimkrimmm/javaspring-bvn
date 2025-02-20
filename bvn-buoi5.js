let todos = [];
        function renderTodos() {
            const list = document.getElementById("todo-list");
            list.innerHTML = "";
            if (todos.length === 0) {
                list.innerHTML = "<li>Danh sách công việc trống</li>";
               
                return;
            }
            todos.forEach((todo, index) => {
                const li = document.createElement("li");
                li.innerHTML = `
                    <span class="${todo.completed ? 'completed' : ''}" onclick="toggleStatus(${index})">
                        ${todo.title}
                    </span>
                    <button onclick="editTodo(${index})">Sửa</button>
                   
                    <button onclick="deleteTodo(${index})">Xóa</button>
                `;
                list.appendChild(li);
            });
        }
        function addTodo() {
            const input = document.getElementById("todo-input");
            const title = input.value.trim();
            if (!title) 
                {
                alert("Tên công việc không được để trống");
                return;
            }
            todos.push({ title, completed: false });
            input.value = "";
            renderTodos();
        }
        
        function deleteTodo(index)
         {
            if (confirm("Bạn có chắc chắn muốn xóa công việc này không?")) {
                todos.splice(index, 1);
                renderTodos();
            }
        }

        function editTodo(index) {
            const newTitle = prompt("Nhập tiêu đề mới:", todos[index].title);
            if (newTitle !== null) 
                {
                todos[index].title = newTitle.trim() || todos[index].title;
                renderTodos();
            }
        }
        function toggleStatus(index) {
            todos[index].completed = !todos[index].completed;
            renderTodos();
        }
        renderTodos();


