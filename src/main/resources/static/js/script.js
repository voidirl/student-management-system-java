const API_URL = "http://localhost:8080/students";

document.addEventListener("DOMContentLoaded", loadStudents);

function loadStudents() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const table = document.getElementById("studentsTable");
            table.innerHTML = "";

            data.forEach(student => {
                const row = `
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                        <td>${student.course}</td>
                        <td>
                            <button onclick="deleteStudent(${student.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;
                table.innerHTML += row;
            });
        })
        .catch(error => console.error("Error:", error));
}

function addStudent() {
    const student = {
        id: document.getElementById("id").value,
        name: document.getElementById("name").value,
        age: document.getElementById("age").value,
        course: document.getElementById("course").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })
        .then(() => {
            clearForm();
            loadStudents();
        });
}

function deleteStudent(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
        .then(() => {
            loadStudents();
        });
}

function clearForm() {
    document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("age").value = "";
    document.getElementById("course").value = "";
}


