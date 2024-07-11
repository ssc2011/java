<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<div class="card-body">
    <div class="input-group mb-3">
        <span class="input-group-text">TNO</span>
        <input type="text" name="tno" class="form-control" value=<c:out value="${dto.tno}"/> readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Title</span>
        <input type="text" name="title" class="form-control" value=<c:out value='${dto.title}'/> readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">DueDate</span>
        <input type="date" name="dueDate" class="form-control" value=<c:out value='${dto.dueDate}'/> readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Writer</span>
        <input type="text" name="writer" class="form-control" value=<c:out value='${dto.writer}'/> readonly>
    </div>
    <div class="form-check">
        <label calss="form-check-label">
            Finished &nbsp;
        </label>
        <input class="form-check-input" type="checkbox" name="finished" ${dto.finished?"checked":""} disabled>
    </div>
    <div class="my-4">
        <div class="float-end">
            <button type="submit" class="btn btn-primary">Modify</button>
            <button type="reset" class="btn btn-secondary">List</button>
        </div>
    </div>
</div>

<script>
    document.querySelector(".btn-primary").addEventListener("click",function(e){ //Modify 버튼
        self.location=`/todo/modify?tno=${dto.tno}&${pageRequestDTO.link}`
    },false)
    document.querySelector(".btn-secondary").addEventListener("click",function(e){ //List 버튼
        self.location="/todo/list?${pageRequestDTO.link}";
    },false)
</script>

