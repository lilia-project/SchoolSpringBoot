<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Add person</title>
  <link rel="stylesheet" href="../styles.css">

</head>

<body>
<header>
  <h1>Add person</h1>
</header>

<#include "../menu.ftlh">
<main>
    <h2>Create a New Person</h2>
    <form action="/teachers/add" method="post">
        <label for="name">Person lastname:</label>
        <input type="text" id="name" name="lastName" required>
        <button type="submit">Create</button>
    </form>
</main>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>

</body>

</html>
