const API_URL = "http://localhost:8080/students";

document.addEventListener("DOMContentLoaded", loadStudents);
let selectedStudentId = null;


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
                            <button onclick="editStudent(${student.id}, '${student.name}', ${student.age}, '${student.course}')">
                                Edit
                            </button>
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
    const id = document.getElementById("id").value;
    const name = document.getElementById("name").value;
    const age = document.getElementById("age").value;
    const course = document.getElementById("course").value;

    if (!id || !name || !age || !course) {
        alert("All fields are required!");
        return;
    }

    const student = { id, name, age, course };

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    }).then(() => {
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
function updateStudent() {
    if (selectedStudentId === null) {
        alert("Click Edit on a student first!");
        return;
    }

    const name = document.getElementById("name").value;
    const age = document.getElementById("age").value;
    const course = document.getElementById("course").value;

    if (!name || !age || !course) {
        alert("All fields are required!");
        return;
    }

    const student = { name, age, course };

    fetch(`${API_URL}/${selectedStudentId}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(student)
    }).then(() => {
        clearForm();
        selectedStudentId = null;
        loadStudents();
    });
}

function editStudent(id, name, age, course) {
    selectedStudentId = id;

    // document.getElementById("id").value = id;
    document.getElementById("id").disabled = true;
    document.getElementById("name").value = name;
    document.getElementById("age").value = age;
    document.getElementById("course").value = course;
}


function clearForm() {
    // document.getElementById("id").value = "";
    document.getElementById("id").disabled = false;

    document.getElementById("name").value = "";
    document.getElementById("age").value = "";
    document.getElementById("course").value = "";
}


