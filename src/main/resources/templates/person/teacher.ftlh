<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Teacher</title>
  <link rel="stylesheet" href="../styles.css">

</head>

<body>
<header>
  <h1>Teacher</h1>
</header>
<#include "../menu.ftlh">
<main>
    <h2>Edit Teacher</h2>
                    <form action="/edit/${person.getId()}" method="post">
                            <label for="name">Teacher Name:</label>
                            <input type="text" id="name" name="name" required>
                            <button type="submit">Edit</button>
                        </form>
</main>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>
</body>

</html>
