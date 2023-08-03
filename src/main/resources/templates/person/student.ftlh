<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Student</title>
  <link rel="stylesheet" href="../styles.css">

</head>

<body>
<header>
  <h1>Student</h1>
</header>
<#include "../menu.ftlh">
<main>
    <h2>Edit Student</h2>
                    <form action="/edit/${person.getId()}" method="post">
                            <label for="name">Student Name:</label>
                            <input type="text" id="name" name="name" required>
                            <button type="submit">Edit</button>
                        </form>
</main>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>
</body>

</html>
