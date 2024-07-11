<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<div class="card-body">
    <form action="/todo/modify" method="post">
    <div class="input-group mb-3">
        <span class="input-group-text">TNO</span>
        <input type="text" name="tno" class="form-control" value=<c:out value="${dto.tno}"/> readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Title</span>
        <input type="text" name="title" class="form-control" value=<c:out value='${dto.title}'/>>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">DueDate</span>
        <input type="date" name="dueDate" class="form-control" value=<c:out value='${dto.dueDate}'/>>
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
            <button type="button" class="btn btn-danger">Remove</button>
            <button type="button" class="btn btn-primary">Modify</button>
            <button type="button" class="btn btn-secondary">List</button>

        </div>
    </div>
    </form>
</div>

<script>
    const formObj=document.querySelector("form")
    //삭제버튼 눌렀을 때
    document.querySelector(".btn-danger").addEventListener("click",function(e){
        e.preventDefault() // 이벤트의 기본 동작을 막음 (여기서는 폼의 기본 제출 동작을 막는다.)
        e.stopPropagation() // 이벤트의 상위 요소로의 전파를 막는다
        formObj.action=`/todo/remove?${pageRequestDTO.link}` // 폼의 action 속성을 "/todo/remove"로 설정
        formObj.method="post" //폼의 method 속성을 "post"로 설정
        formObj.submit()
    },false)

    //수정버튼 눌렀을 때
    document.querySelector(".btn-primary").addEventListener("click",function(e){
        e.preventDefault()
        e.stopPropagation()
        formObj.action="/todo/modify"
        formObj.method="post"
        formObj.submit()
    },false)

    //@Valid에서 문제가 생겼을 때 처리
    const serverValidResult={}
    <c:forEach items="${errors}" var="error">
    serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
    </c:forEach>
    console.log(serverValidResult)

    //List버튼 처리
    document.querySelector(".btn-secondary").addEventListener("click",function (e){
        e.preventDefault()
        e.stopPropagation()

        self.location=`/todo/list?${pageRequestDTO.link}`; //link에 담겨있는 page,size 정보와 같이 현재 페이지를 todolist로 변경함
    },false);
</script>

