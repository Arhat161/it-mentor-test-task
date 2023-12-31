<h1>ТЕСТОВАЯ ЗАДАЧА “КАЛЬКУЛЯТОР”</h1>
<h3>Описание:</h3>
<p>Создай консольное приложение “Калькулятор”.</p> 
<p>Приложение должно читать из консоли введенные пользователем строки, числа, арифметические операции проводимые между ними и выводить в консоль результат их выполнения.</p>
<p>Реализуй класс Main с методом public static String calc(String input).</p>  
<p>Метод должен принимать строку с арифметическим выражением между двумя числами и возвращать строку с результатом их выполнения.</p>  
<p>Ты можешь добавлять свои импорты, классы и методы. Добавленные классы не должны иметь модификаторы доступа (public или другие)</p> 
<h3>Требования:</h3>
<ul>
<li>Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.</li> 
<li>Данные передаются в одну строку (смотри пример)! Решения, в которых каждое число и арифметическая операция передаются с новой строки считаются неверными.</li>
<li>Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.</li>
<li>Калькулятор умеет работать только с целыми числами.</li>
<li>При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.</li>
<li>При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.</li>
<li>Результатом операции деления является целое число, остаток отбрасывается.</li>
<li>Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.</li>
</ul>

<h3>Пример работы программы:</h3>
<pre>
Input:
1 + 2
Output:
3
Input:
1
Output:
throws Exception //т.к. строка не является математической операцией
Input:
1 + 2 1
Output:
throws Exception
Input:
1 + 2 + 3
Output:
throws Exception //т.к. формат математической операции не удовлетворяет заданию 
- два операнда и один оператор (+, -, /, *)
</pre>

<h3>Как отправить решение?</h3>
<p>
Решение нужно выгрузить на git и отправить ссылку на репозиторий на почту test_task@it-mentor.tech, тема письма — “тестовое задание”
</p>
<p>ВАЖНО! После этого отпишитесь своему HR от которого получили это задание!</p>
<p>При отправке тестового задания, проверьте что указаны ваше ФИО, задание открывается по ГИТ ссылке, и оно полностью соответствует требованиям и примерам ;)</p>

<p>
Если ты не знаком(а) с git и Github, прочитай эту статью или эту статью, в ней описаны основы работы с git.
</p>
<p>
Далее нужно создать собственный репозиторий и добавить туда проект с решением.
</p>
<p>
Успехов тебе в выполнении Тестового задания !
</p>
