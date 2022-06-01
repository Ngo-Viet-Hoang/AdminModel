<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.adminmodel.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/admin/components/header.jsp" />


<body>
<div class="container-scroller">
    <!-- partial:../../partials/_navbar.html -->
    <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex align-items-top flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-start">
            <div class="me-3">
                <button class="navbar-toggler navbar-toggler align-self-center" type="button" data-bs-toggle="minimize">
                    <span class="icon-menu"></span>
                </button>
            </div>
            <div>
                <a class="navbar-brand brand-logo" href="../../index.html">
                    <img src="/admin/assets/images/logo.svg" alt="logo" />
                </a>
                <a class="navbar-brand brand-logo-mini" href="../../index.html">
                    <img src="/admin/assets/images/logo-mini.svg" alt="logo" />
                </a>
            </div>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-top">
            <ul class="navbar-nav">
                <li class="nav-item font-weight-semibold d-none d-lg-block ms-0">
                    <h1 class="welcome-text">Good Morning, <span class="text-black fw-bold">John Doe</span></h1>
                    <h3 class="welcome-sub-text">Your performance summary this week </h3>
                </li>
            </ul>
            <ul class="navbar-nav ms-auto">
                <li class="nav-item dropdown d-none d-lg-block">
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list pb-0" aria-labelledby="messageDropdown">
                        <a class="dropdown-item py-3" >
                            <p class="mb-0 font-weight-medium float-left">Select category</p>
                        </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item preview-item">
                            <div class="preview-item-content flex-grow py-2">
                                <p class="preview-subject ellipsis font-weight-medium text-dark">Bootstrap Bundle </p>
                                <p class="fw-light small-text mb-0">This is a Bundle featuring 16 unique dashboards</p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-item-content flex-grow py-2">
                                <p class="preview-subject ellipsis font-weight-medium text-dark">Angular Bundle</p>
                                <p class="fw-light small-text mb-0">Everything you’ll ever need for your Angular projects</p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-item-content flex-grow py-2">
                                <p class="preview-subject ellipsis font-weight-medium text-dark">VUE Bundle</p>
                                <p class="fw-light small-text mb-0">Bundle of 6 Premium Vue Admin Dashboard</p>
                            </div>
                        </a>
                        <a class="dropdown-item preview-item">
                            <div class="preview-item-content flex-grow py-2">
                                <p class="preview-subject ellipsis font-weight-medium text-dark">React Bundle</p>
                                <p class="fw-light small-text mb-0">Bundle of 8 Premium React Admin Dashboard</p>
                            </div>
                        </a>
                    </div>
                </li>
                <li class="nav-item d-none d-lg-block">
                    <div id="datepicker-popup" class="input-group date datepicker navbar-date-picker">
              <span class="input-group-addon input-group-prepend border-right">
                <span class="icon-calendar input-group-text calendar-icon"></span>
              </span>
                        <input type="text" class="form-control">
                    </div>
                </li>
                <li class="nav-item">
                    <form class="search-form" action="#">
                        <i class="icon-search"></i>
                        <input type="search" class="form-control" placeholder="Search Here" title="Search here">
                    </form>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link count-indicator" id="notificationDropdown" href="#" data-bs-toggle="dropdown">
                        <i class="icon-mail icon-lg"></i>
                    </a>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-bs-toggle="offcanvas">
                <span class="mdi mdi-menu"></span>
            </button>
        </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_settings-panel.html -->

        <jsp:include page="/admin/components/settings-panel.jsp" />
        <!-- partial -->
        <!-- partial:../../partials/_sidebar.html -->
        <jsp:include page="/admin/components/sidebar.jsp"/>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Product List</h4>
<%--                                <button  type="submit" class="btn btn-primary me-2">Add New </button>--%>
                                <a href="<%=request.getContextPath()%>/products/create" class="btn btn-success">Add
                                    New Account</a>

                                <div class="table-responsive pt-3">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                ID
                                            </th>
                                            <th>
                                                Thumbnail
                                            </th>
                                            <th>
                                                Name
                                            </th>
                                            <th>
                                                Price
                                            </th>

                                            <th>
                                                Status
                                            </th>
                                            <th>
                                                Created At
                                            </th>
                                            <th>
                                                Updated At
                                            </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%
                                            List<Product> products = (ArrayList<Product>) request.getAttribute("productList");
                                            for(Product product : products) {%>
                                        <tr>
                                            <td>
                                                <%= product.getId() %>
                                            <td>
                                                <img width="200" src="<%= product.getThumbnail() %>" />
                                            </td>
                                            <td><%= product.getName() %></td>
                                            <td><%= product.getPrice() %></td>
                                            <td><%= product.getProductStatus() %></td>
                                            <td><%= product.getCreatedAt() %></td>
                                            <td><%= product.getUpdatedAt() %></td>
                                            </td>
                                            <td>
                                                <a class="btn btn-primary" href="/update?id=<%= product.getId() %>">Edit</a>
                                                <button class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal<%= product.getId() %>">Delete</button>
                                                <!-- Modal -->
                                                <div class="modal fade" id="exampleModal<%= product.getId() %>" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Alert</h5>
                                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                Are you sure delete <%= product.getName() %>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                                                <a href="/delete?id=<%= product.getId() %>" class="btn btn-danger">Delete</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>

                                        </tr>
                                        <%}%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            ->
        </div>

        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="/admin/assets/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="/admin/assets/vendors/typeahead.js/typeahead.bundle.min.js"></script>
<script src="/admin/assets/vendors/select2/select2.min.js"></script>
<script src="/admin/assets/vendors/bootstrap-datepicker/bootstrap-datepicker.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="/admin/assets/js/off-canvas.js"></script>
<script src="/admin/assets/js/hoverable-collapse.js"></script>
<script src="/admin/assets/js/template.js"></script>
<script src="/admin/assets/js/settings.js"></script>
<script src="/admin/assets/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="/admin/assets/js/file-upload.js"></script>
<script src="/admin/assets/js/typeahead.js"></script>
<script src="/admin/assets/js/select2.js"></script>
<!-- End custom js for this page-->
</body>

</html>
