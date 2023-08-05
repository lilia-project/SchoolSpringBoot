<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Course</title>
  <link rel="stylesheet" href="../styles.css">

</head>

<body>
<header>
  <h1>Course</h1>
</header>
<#include "../menu.ftlh">
    <main>
        <td>
            ${course}
        </td>
        <h2>Edit Course</h2>
               <form action="/edit/${course.getId()}" method="post">
                       <label for="name">Course Name:</label>
                       <input type="text" id="name" name="name" required>
                       <button type="submit">Edit</button>
               </form>
    </main>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>
</body>

</html>
