<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Example Application Spring and Bootstrap</title>


        <script src="<c:url value="/resources/grid/js/jquery-2.2.3.min.js"/>"></script>
        <script src="<c:url value="/resources/grid/js/bootstrap/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/resources/grid/js/bootstrap/js/moment.js"/>"></script>
        <script src="<c:url value="/resources/grid/js/bootstrap/js/bootstrap-datetimepicker.js"/>"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/resources/grid/js/bootstrap/css/bootstrap.min.css"/>">
        <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
        <script src="<c:url value="/resources/grid/jsRocket/bootstrapSpringGrid.js"/>"></script>

    </head>
    <body>

        <div class="container">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <button type="button" id="buttonSearch" class="btn btn-info">
                        <span class="glyphicon glyphicon-search"></span> Search
                    </button>
                    <button type="button" id="buttonInsert" class="btn btn-success">
                        <span class="glyphicon glyphicon-plus-sign"></span> Insert
                    </button>
                    <button type="button" id="buttonDelete" class="btn btn-warning">
                        <span class="glyphicon glyphicon-minus-sign"></span> Delete
                    </button>
                </div>
                <div>
                    <table id="tableClient" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th class="col-sm-1" data-field="id">Id</th>
                                <th class="col-sm-1" data-field="checkDelete"></th>
                                <th class="col-sm-3" data-field="name">Class Name</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </form>
        </div>
    </body>
</html>