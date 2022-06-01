<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.adminmodel.entity.Product" %>
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
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Products</h4>
                                <p class="card-description">
                                    Create
                                </p>
                                <form class="forms-sample">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control" id="name" name="name"  placeholder="Name">

                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <input type="text" class="form-control"  id="description" name="description" placeholder="Description">
                                    </div>
                                    <div class="form-group">
                                        <label for="detail">Detail</label>
                                        <textarea class="form-control" id="detail" rows="4"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="price">Price</label>
                                        <input  class="form-control" id="price" name="price" placeholder="Price">
                                    </div>
                                    <div class="form-group">
                                        <label for="manufactureEmail">Manufacture Email</label>
                                        <input type="text"  class="form-control" id="manufactureEmail" name="manufactureEmail" placeholder="Manufacture Email">
                                    </div>
                                    <div class="form-group">
                                        <label for="manufacturePhone">Manufacture Phone</label>
                                        <input type="text"  class="form-control" id="manufacturePhone" name="manufacturePhone" placeholder="Manufacture Phone">
                                    </div>
                                    <div class="form-group">
                                        <label>Thumbnail</label>
                                        <input type="file" name="img[]" class="file-upload-default">
                                        <div class="input-group col-xs-12">
                                            <input type="text" name="thumbnail" class="form-control file-upload-info" disabled placeholder="Upload Thumbnail">
                                            <span class="input-group-append">
                          <button class="file-upload-browse btn btn-primary" type="button">Upload</button>
                        </span>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary me-2">Submit</button>
                                    <button class="btn btn-light">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <jsp:include page="/admin/components/footer.jsp" />
            <!-- partial -->
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