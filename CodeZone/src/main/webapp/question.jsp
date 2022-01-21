<%@ page import="com.zone.codezone.Models.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zone.codezone.Dao.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: otman
  Date: 10/01/2022
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Test> testList = DaoFactory.getTestDao().findAll(); %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<div class="container text-center">
    <form action="question-chois" method="post">
        <h1>TEST Question</h1>
        <div class="form-floating mb-3">
            <input type="text" name="content" class="form-control" id="content" placeholder="example">
            <label for="content">Content :</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="time" class="form-control" id="time" placeholder="example">
            <label for="time">Question Time (S) :</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" name="score" class="form-control" id="score" placeholder="example">
            <label for="score">Question Score :</label>
        </div>
        <select class="form-select my-2" name="test_id" aria-label="Default select example">
            <option selected>Open this select menu</option>
            <% for (Test test : testList) {%>
            <option value="<%= test.getId()  %>"><%= test.getTitle().toUpperCase() %>
            </option>
            <% }%>
        </select>
        <h1> Question Chois </h1>
        <div class="input-group mt-5 mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_one"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_one" class="form-control " id="chose_one" placeholder="example">
                <label for="chose_one">Chose One :</label>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_tow"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_tow" class="form-control" id="chose_tow" placeholder="example">
                <label for="chose_tow">Chose tow :</label>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_three"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_three" class="form-control" id="chose_three" placeholder="example">
                <label for="chose_three">Chose three :</label>
            </div>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-text">
                <span class="">is correct </span>
                <input class="form-radio-input mt-0 mx-3" type="radio" name="flexRadioDefault" value="chose_four"
                       aria-label="radio for following text input">
            </div>
            <div class="form-floating w-100">
                <input type="text" name="chose_four" class="form-control" id="chose_four" placeholder="example">
                <label for="chose_four">Chose four :</label>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary w-50 mt-5">Save</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

</body>
</html>
