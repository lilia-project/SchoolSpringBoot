<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Add course</title>
  <link rel="stylesheet" href="../styles.css">

</head>

<body>
<header>
  <h1>Add course</h1>
</header>

<#include "../menu.ftlh">
<main>
    <h2>Create a New Course</h2>
    <form action="/courses/add" method="post">
        <label for="name">Course Name:</label>
        <input type="text" id="name" name="name" required>
        <button type="submit">Create</button>
    </form>
</main>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>

</body>

</html>
