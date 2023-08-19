<!DOCTYPE html>
<html>
<head>
    <title>Test</title>
    <script>

        function showMessage() {
            var name = prompt("What is Programming?\n 1 - Programming is a process of writing programs using programming languages,\n 2 - It means to make sites,\n 3 - It means Web App creation");
            Number(name);
            var result = 0;
            if (name == 1) {
                result++;
            }
            var name = prompt("What is WEB App?\n 1 - It is a program on my computer\n 2 - It is a program in my smartphone\n 3 - It is a program in a web browser");
            Number(name);
             if (name == 3) {
                result++;
            }
              var name = prompt("What is Desktop App?\n 1 - It is a program on my computer\n 2 - It is a program in my smartphone\n 3 - It is a program in a web browser");
            Number(name);
             if (name == 1) {
                result++;
            }
            document.getElementById("result").value = result.toFixed(0);
            return result;
        }
    </script>
</head>
<body>
<h2>Test</h2>
<button onclick="showMessage()">Start</button><br>
<label>result: <input type="number" id="result" disabled> from 3</label>

</body>
</html>