<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.adminmodel.entity.Product" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/admin/components/header.jsp" />


<body>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors == null) {
        errors = new HashMap<>();
    }
    Product product = (Product) request.getAttribute("product");
    if(product == null) {
        product = new Product();
    }
%>

<div class="container-scroller">
    <jsp:include page="/admin/components/narbar.jsp"/>
    <div class="container-fluid page-body-wrapper">
       <jsp:include page="/admin/components/settings-panel.jsp" />
       <jsp:include page="/admin/components/sidebar.jsp"/>

        <div class="main-panel" action="/products/create" method="post" >
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Products</h4>
                                <p class="card-description">
                                    Create
                                </p>
                                <form class="forms-sample" action="/products/create" method="post">
                                    <div class="form-group">
                                        <label for="name">Name</label>
                                        <input type="text" class="form-control" id="name" name="name"  value="<%= product.getName() %>"  placeholder="Name">
                                        <%
                                            if(errors.containsKey("name"))   {
                                        %>
                                        <div class="invalid-feedback">
                                            <%= errors.get("name")%>
                                        </div>
                                        <% } %>

                                    </div>
                                    <div class="form-group">
                                        <label for="description">Description</label>
                                        <input type="text" class="form-control"  id="description" name="description" value="<%= product.getDescription() %>" placeholder="Description">

                                    </div>
                                    <div class="form-group">
                                        <label for="detail">Detail</label>
                                        <textarea name="detail" class="form-control" id="detail" rows="4">
                                             <%= product.getDetail() %>
                                        </textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="price">Price</label>
                                        <input  class="form-control" id="price" name="price" placeholder="Price"  value="<%= product.getPrice() %>">
                                        <%
                                            if(errors.containsKey("price"))   {
                                        %>
                                        <div class="invalid-feedback">
                                            <%= errors.get("price")%>
                                        </div>
                                        <% } %>

                                    </div>
                                    <div class="form-group">
                                        <label for="manufactureEmail">Manufacture Email</label>
                                        <input type="text"  class="form-control" id="manufactureEmail" name="manufactureEmail" placeholder="Manufacture Email" value="<%= product.getManufactureEmail() %>">
                                        <%
                                            if(errors.containsKey("manufactureEmail"))   {
                                        %>
                                        <div class="invalid-feedback">
                                            <%= errors.get("manufactureEmail")%>
                                        </div>
                                        <% } %>
                                    </div>
                                    <div class="form-group">
                                        <label for="manufacturePhone">Manufacture Phone</label>
                                        <input type="text"  class="form-control" id="manufacturePhone" name="manufacturePhone" placeholder="Manufacture Phone"  value="<%= product.getManufacturePhone() %>">
                                        <%
                                            if(errors.containsKey("manufacturePhone"))   {
                                        %>
                                        <div class="invalid-feedback">
                                            <%= errors.get("manufacturePhone")%>
                                        </div>
                                        <% } %>
                                    </div>
                                    <div class="form-group">
                                        <label for="thumbnail">Thumbnail</label>>
                                        <div class="input-group col-xs-12">
                                            <input type="text" id="thumbnail" name="thumbnail" class="form-control "  placeholder="Upload Thumbnail" value="<%= product.getThumbnail() %>">
                                            <%
                                                if(errors.containsKey("thumbnail"))   {
                                            %>
                                            <div class="invalid-feedback">
                                                <%= errors.get("thumbnail")%>
                                            </div>
                                            <% } %>
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
    </div>
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