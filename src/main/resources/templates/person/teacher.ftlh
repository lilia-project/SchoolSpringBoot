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
    <td>
           ${person}
       </td>
    <h2>Edit Teacher</h2>
                    <form action="/edit/${person.getId()}" method="post">
                            <label for="name">role:</label>
                            <input type="text" id="name" name="name" required>
                            <button type="submit">Edit</button>
                    </form>
                    <form action="/edit/${person.getId()}" method="post">
                            <label for="name">lastname:</label>
                            <input type="text" id="name" name="name" required>
                            <button type="submit">Edit</button>
                    </form>
                    <form action="/edit/${person.getId()}" method="post">
                             <label for="name">firstname:</label>
                             <input type="text" id="name" name="name" required>
                             <button type="submit">Edit</button>
                    </form>
                    <form action="/edit/${person.getId()}" method="post">
                             <label for="name">phone:</label>
                             <input type="text" id="name" name="name" required>
                             <button type="submit">Edit</button>
                    </form> <form action="/edit/${person.getId()}" method="post">
                             <label for="name"> email:</label>
                             <input type="text" id="name" name="name" required>
                             <button type="submit">Edit</button>
                    </form>
</main>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>
</body>

</html>
