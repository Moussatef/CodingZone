<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<z:layout pageTitle="Create Test">
<div class="card add-form">
            <h2>Create Test</h2>

            <form method="post" action="${pageContext.request.contextPath}/add-test">
                <div class="input-group">
                    <label for="title">Test Title</label>
                    <input type="text" name="title" id="title" placeholder="Title" required/>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <label for="start_date">Start Date</label>
                        <input type="date" name="start_date" id="start_date" placeholder="Start Date" required/>
                    </div>
                    <div class="input-group">
                        <label for="end_date">End Date</label>
                        <input type="date" name="end_date" id="end_date" placeholder="End Date" required/>
                    </div>
                </div>

                <div class="input-group">
                    <label for="competence">Competences</label>
                    <select name="competence" id="competence" required> <!-- get all competence then loop on it -->

                        <option>Select Competence</option>
                        <c:forEach items="${competence}" var="comp">
                            <option value="${comp.getId()}">${comp.getCompetence_name()}</option>
                        </c:forEach>
                    </select>
                </div>
                <c:if test="${error != null}">
                    <div class="error">
                        <p>${error}</p>
                    </div>
                </c:if>
                <input type="submit" value="Submit"/>
            </form>
        </div>
</z:layout>