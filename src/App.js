  import React, { useState, useEffect } from 'react';
  import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
  import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
  import { faHome, faShoppingCart, faBox, faUsers, faTruck, faWarehouse, faUserTie, faChartLine } from '@fortawesome/free-solid-svg-icons';
  import DatePicker from 'react-datepicker';
  import { Card, Row, Col, Container, ProgressBar, Table, Button, Form } from 'react-bootstrap';
  import './OrdersPage.css';
  import './CustomersPage.css';
  import './ProductPage.css';
  import 'react-datepicker/dist/react-datepicker.css';
  import 'bootstrap/dist/css/bootstrap.min.css';
  import { Line } from 'react-chartjs-2';
  import 'chart.js/auto';
  import './index.css'; 
  import './StockManagementPage.css'; 
  import './App.css';
  import './Dashboard.css';
  import './User.css';
  function Dashboard({ userList, productList }) {
    const [totalOrders, setTotalOrders] = useState(0);
    const [totalRevenue, setTotalRevenue] = useState(0);
    const [lowStockProducts, setLowStockProducts] = useState([]);
  
    useEffect(() => {
      setTotalOrders(150); // Example value
      setTotalRevenue(5000); // Example value
      setLowStockProducts(productList.filter((product) => product.stock < 10));
    }, [productList]);
  
    const revenueData = {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
      datasets: [
        {
          label: 'Revenue over time',
          data: [65, 59, 80, 81, 56, 55, 40],
          fill: false,
          borderColor: 'rgb(75, 192, 192)',
          tension: 0.1,
        },
      ],
    };
  
    return (
      <div className="container mt-4">
        <h2 className="text-center mb-4">Dashboard</h2>
        <Row>
          <Col md={3} className="mb-4">
            <Card className="shadow rounded">
              <Card.Body>
                <Card.Title>Total Products</Card.Title>
                <Card.Text>{productList.length}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
          <Col md={3} className="mb-4">
            <Card className="shadow rounded">
              <Card.Body>
                <Card.Title>Total Orders</Card.Title>
                <Card.Text>{totalOrders}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
          <Col md={3} className="mb-4">
            <Card className="shadow rounded">
              <Card.Body>
                <Card.Title>Total Revenue</Card.Title>
                <Card.Text>${totalRevenue}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
          <Col md={3} className="mb-4">
            <Card className="shadow rounded">
              <Card.Body>
                <Card.Title>Total Customers</Card.Title>
                <Card.Text>{userList.length}</Card.Text>
              </Card.Body>
            </Card>
          </Col>
        </Row>
        <Row>
          <Col md={6}>
            <h5>Revenue Over Time</h5>
            <Line data={revenueData} />
          </Col>
          <Col md={6}>
            <h5>Low Stock Products</h5>
            <ul className="list-group">
              {lowStockProducts.map((product) => (
                <li key={product.id} className="list-group-item">
                  {product.name} - {product.stock} left
                </li>
              ))}
            </ul>
          </Col>
        </Row>
      </div>
    );
  }




  
  function UserPage({ userList, setUserList, newUser, setNewUser, handleInputChange, addUser, editUser, deleteUser }) {
    return (
      <div className="container mt-4">
        <h2 className="text-center mb-4">Users</h2>
        <Table striped bordered hover responsive>
          <thead>
            <tr>
              <th>ID</th>
              <th>Username</th>
              <th>Password</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Address</th>
              <th>Role</th>
              <th>Created At</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {userList.map((user) => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.username}</td>
                <td>{user.password}</td>
                <td>{user.email}</td>
                <td>{user.phone}</td>
                <td>{user.address}</td>
                <td>{user.role}</td>
                <td>{user.created_at}</td>
                <td>
                  <Button onClick={() => editUser(user)} variant="warning" size="sm" className="me-2">Edit</Button>
                  <Button onClick={() => deleteUser(user.id)} variant="danger" size="sm">Delete</Button>
                </td>
              </tr>
            ))}
            <tr>
              <td></td>
              <td>
                <Form.Control type="text" name="username" placeholder="Username" value={newUser.username} onChange={handleInputChange} />
              </td>
              <td>
                <Form.Control type="password" name="password" placeholder="Password" value={newUser.password} onChange={handleInputChange} />
              </td>
              <td>
                <Form.Control type="email" name="email" placeholder="Email" value={newUser.email} onChange={handleInputChange} />
              </td>
              <td>
                <Form.Control type="text" name="phone" placeholder="Phone" value={newUser.phone} onChange={handleInputChange} />
              </td>
              <td>
                <Form.Control type="text" name="address" placeholder="Address" value={newUser.address} onChange={handleInputChange} />
              </td>
              <td>
                <Form.Select name="role" value={newUser.role} onChange={handleInputChange}>
                  <option value="customer">Customer</option>
                  <option value="admin">Admin</option>
                </Form.Select>
              </td>
              <td>
                <Form.Control type="datetime-local" name="created_at" placeholder="Created At" value={newUser.created_at} onChange={handleInputChange} />
              </td>
              <td>
                <Button variant="primary" onClick={addUser}>{newUser.id ? 'Update' : 'Add'}</Button>
              </td>
            </tr>
          </tbody>
        </Table>
      </div>
    );
  }

    



  function OrdersPage({ ordersList, setOrdersList, productList }) {
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedOrder, setSelectedOrder] = useState(null);
    const [editStatusOrder, setEditStatusOrder] = useState(null);
    const [newStatus, setNewStatus] = useState('Pending');
  
    const handleSearchChange = (e) => {
      setSearchTerm(e.target.value);
    };
  
    const handleViewDetails = (order) => {
      const productsInOrder = order.products.map((product) => {
        const productDetails = productList.find((p) => p.id === product.product_id);
        return {
          ...product,
          name: productDetails ? productDetails.name : 'Unknown Product'
        };
      });
      setSelectedOrder({ ...order, products: productsInOrder });
    };
  
    const handleEditStatus = (order) => {
      setEditStatusOrder(order);
      setNewStatus(order.status);
    };
  
    const handleStatusChange = (e) => {
      setNewStatus(e.target.value);
    };
  
    const saveStatusChange = () => {
      setOrdersList((prevOrders) =>
        prevOrders.map((order) =>
          order.id === editStatusOrder.id ? { ...order, status: newStatus } : order
        )
      );
      setEditStatusOrder(null);
    };
  
    const filteredOrders = ordersList.filter(
      (order) =>
        order.id.toString().includes(searchTerm) ||
        order.customer.toLowerCase().includes(searchTerm.toLowerCase())
    );
  
    return (
      <div className="container py-5">
        <h2 className="text-center mb-4">Orders Management</h2>
  
        {/* Search Box */}
        <div className="mb-4">
          <input
            type="text"
            placeholder="Search by Order ID or Customer Name"
            value={searchTerm}
            onChange={handleSearchChange}
            className="form-control form-control-lg"
          />
        </div>
  
        {/* Orders Table */}
        <div className="table-responsive">
          <table className="table table-striped table-hover">
            <thead>
              <tr>
                <th>Order ID</th>
                <th>Customer</th>
                <th>Total Amount</th>
                <th>Status</th>
                <th>Created At</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {filteredOrders.map((order) => (
                <tr key={order.id}>
                  <td>{order.id}</td>
                  <td>{order.customer}</td>
                  <td>{order.total}</td>
                  <td>{order.status}</td>
                  <td>{order.created_at}</td>
                  <td>
                    <button
                      className="btn btn-info btn-sm"
                      onClick={() => handleViewDetails(order)}
                      data-bs-toggle="modal"
                      data-bs-target="#viewDetailsModal"
                    >
                      View Details
                    </button>
                    <button
                      className="btn btn-warning btn-sm ms-2"
                      onClick={() => handleEditStatus(order)}
                      data-bs-toggle="modal"
                      data-bs-target="#editStatusModal"
                    >
                      Edit Status
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
  
        {/* View Details Modal */}
        {selectedOrder && (
          <div
            className="modal fade"
            id="viewDetailsModal"
            tabIndex="-1"
            aria-labelledby="viewDetailsModalLabel"
            aria-hidden="true"
          >
            <div className="modal-dialog modal-lg">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title" id="viewDetailsModalLabel">
                    Order Details
                  </h5>
                  <button
                    type="button"
                    className="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div className="modal-body">
                  <p><strong>Order ID:</strong> {selectedOrder.id}</p>
                  <p><strong>Customer:</strong> {selectedOrder.customer}</p>
                  <p><strong>Total Amount:</strong> {selectedOrder.total}</p>
                  <p><strong>Status:</strong> {selectedOrder.status}</p>
                  <p><strong>Created At:</strong> {selectedOrder.created_at}</p>
                  <h5 className="mt-4">Products:</h5>
                  <table className="table table-bordered">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Order ID</th>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                      </tr>
                    </thead>
                    <tbody>
                      {selectedOrder.products.map((product, index) => (
                        <tr key={index}>
                          <td>{product.id}</td>
                          <td>{selectedOrder.id}</td>
                          <td>{product.product_id}</td>
                          <td>{product.name}</td>
                          <td>{product.quantity}</td>
                          <td>{product.price}</td>
                        </tr>
                      ))}
                    </tbody>
                  </table>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Close
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}
  
        {/* Edit Status Modal */}
        {editStatusOrder && (
          <div
            className="modal fade"
            id="editStatusModal"
            tabIndex="-1"
            aria-labelledby="editStatusModalLabel"
            aria-hidden="true"
          >
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title" id="editStatusModalLabel">
                    Edit Order Status
                  </h5>
                  <button
                    type="button"
                    className="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div className="modal-body">
                  <p><strong>Order ID:</strong> {editStatusOrder.id}</p>
                  <p><strong>Current Status:</strong> {editStatusOrder.status}</p>
                  <div className="mb-3">
                    <label htmlFor="statusSelect" className="form-label">
                      New Status
                    </label>
                    <select
                      id="statusSelect"
                      className="form-select"
                      value={newStatus}
                      onChange={handleStatusChange}
                    >
                      <option value="Pending">Pending</option>
                      <option value="Completed">Completed</option>
                      <option value="Cancelled">Cancelled</option>
                    </select>
                  </div>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Cancel
                  </button>
                  <button
                    type="button"
                    className="btn btn-primary"
                    onClick={saveStatusChange}
                    data-bs-dismiss="modal"
                  >
                    Save Changes
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}
      </div>
    );
  }
  
    
  function ProductPage({
    productList,
    setProductList,
    newProduct,
    setNewProduct,
    handleInputChange,
    addProduct,
    editProduct,
    deleteProduct,
    toggleProductStatus
  }) {
    return (
      <div className="container py-5">
        <h2 className="text-center mb-4">Products Management</h2>
  
        {/* Products Table */}
        <div className="table-responsive">
          <table className="table table-striped table-hover">
            <thead className="table-dark">
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Stock</th>
                <th>Category</th>
                <th>Image URL</th>
                <th>Status</th>
                <th>Created At</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {productList.map((product) => (
                <tr key={product.id}>
                  <td>{product.id}</td>
                  <td>{product.name}</td>
                  <td>{product.description}</td>
                  <td>{product.price}</td>
                  <td>{product.stock}</td>
                  <td>{product.category}</td>
                  <td>
                    <a href={product.image_url} target="_blank" rel="noopener noreferrer">
                      View Image
                    </a>
                  </td>
                  <td>{product.status}</td>
                  <td>{product.created_at}</td>
                  <td>
                    <button onClick={() => editProduct(product)} className="btn btn-warning btn-sm">Edit</button>
                    <button onClick={() => deleteProduct(product.id)} className="btn btn-danger btn-sm ms-2">Delete</button>
                    <button onClick={() => toggleProductStatus(product.id)} className="btn btn-secondary btn-sm ms-2">
                      {product.status === 'active' ? 'Hide' : 'Show'}
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
  
        {/* Add or Edit Product Form */}
        <div className="card mt-5">
          <div className="card-header">
            <h4>{newProduct.id ? 'Edit Product' : 'Add New Product'}</h4>
          </div>
          <div className="card-body">
            <form>
              <div className="row">
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="name">Name</label>
                  <input
                    type="text"
                    id="name"
                    name="name"
                    placeholder="Enter product name"
                    value={newProduct.name}
                    onChange={handleInputChange}
                    className="form-control"
                  />
                </div>
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="price">Price</label>
                  <input
                    type="number"
                    id="price"
                    name="price"
                    placeholder="Enter product price"
                    value={newProduct.price}
                    onChange={handleInputChange}
                    className="form-control"
                  />
                </div>
              </div>
              <div className="row">
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="stock">Stock</label>
                  <input
                    type="number"
                    id="stock"
                    name="stock"
                    placeholder="Enter stock quantity"
                    value={newProduct.stock}
                    onChange={handleInputChange}
                    className="form-control"
                  />
                </div>
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="category">Category</label>
                  <input
                    type="text"
                    id="category"
                    name="category"
                    placeholder="Enter product category"
                    value={newProduct.category}
                    onChange={handleInputChange}
                    className="form-control"
                  />
                </div>
              </div>
              <div className="row">
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="image_url">Image URL</label>
                  <input
                    type="text"
                    id="image_url"
                    name="image_url"
                    placeholder="Enter image URL"
                    value={newProduct.image_url}
                    onChange={handleInputChange}
                    className="form-control"
                  />
                </div>
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="status">Status</label>
                  <select
                    name="status"
                    value={newProduct.status}
                    onChange={handleInputChange}
                    className="form-select"
                  >
                    <option value="active">Active</option>
                    <option value="hidden">Hidden</option>
                  </select>
                </div>
              </div>
              <div className="row">
                <div className="col-md-6 mb-3">
                  <label className="form-label" htmlFor="created_at">Created At</label>
                  <input
                    type="text"
                    id="created_at"
                    name="created_at"
                    value={newProduct.created_at}
                    onChange={handleInputChange}
                    className="form-control"
                    disabled
                  />
                </div>
                <div className="col-md-6 d-flex align-items-end mb-3">
                  <button
                    className="btn btn-primary w-100"
                    onClick={addProduct}
                    type="button"
                  >
                    {newProduct.id ? 'Update Product' : 'Add Product'}
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    );
  }
    
  function CustomersPage({ customersList, setCustomersList }) {
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedCustomer, setSelectedCustomer] = useState(null);
  
    const handleSearchChange = (e) => {
      setSearchTerm(e.target.value);
    };
  
    const handleViewDetails = (customer) => {
      setSelectedCustomer(customer);
    };
  
    const filteredCustomers = customersList.filter(
      (customer) =>
        customer.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
        customer.email.toLowerCase().includes(searchTerm.toLowerCase())
    );
  
    return (
      <div className="container">
        <h2>Customers Management</h2>
        <div className="mb-3">
          <input
            type="text"
            placeholder="Search by Name or Email"
            value={searchTerm}
            onChange={handleSearchChange}
            className="form-control"
          />
        </div>
        <table className="table table-hover">
          <thead>
            <tr>
              <th>Customer ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Address</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {filteredCustomers.map((customer) => (
              <tr key={customer.id}>
                <td>{customer.id}</td>
                <td>{customer.name}</td>
                <td>{customer.email}</td>
                <td>{customer.phone}</td>
                <td>{customer.address}</td>
                <td>
                  <button
                    className="btn btn-info btn-sm"
                    onClick={() => handleViewDetails(customer)}
                    data-bs-toggle="modal"
                    data-bs-target="#viewCustomerDetailsModal"
                  >
                    View Details
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
  
        {/* View Customer Details Modal */}
        {selectedCustomer && (
          <div
            className="modal fade"
            id="viewCustomerDetailsModal"
            tabIndex="-1"
            aria-labelledby="viewCustomerDetailsModalLabel"
            aria-hidden="true"
          >
            <div className="modal-dialog">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title" id="viewCustomerDetailsModalLabel">
                    Customer Details
                  </h5>
                  <button
                    type="button"
                    className="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div className="modal-body">
                  <p><strong>Customer ID:</strong> {selectedCustomer.id}</p>
                  <p><strong>Name:</strong> {selectedCustomer.name}</p>
                  <p><strong>Email:</strong> {selectedCustomer.email}</p>
                  <p><strong>Phone:</strong> {selectedCustomer.phone}</p>
                  <p><strong>Address:</strong> {selectedCustomer.address}</p>
                  <h5>Order History:</h5>
                  <ul>
                    {selectedCustomer.orderHistory.map((order, index) => (
                      <li key={index}>
                        Order ID: {order.id}, Total: {order.total}, Date: {order.date}
                      </li>
                    ))}
                  </ul>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Close
                  </button>
                </div>
              </div>
            </div>
          </div>
        )}
      </div>
    );
  }
  
    
  function StockManagementPage({ stockEntries, setStockEntries, productList, setProductList }) {
    const [newStockEntry, setNewStockEntry] = useState({
      productId: '',
      supplier: '',
      quantity: 0,
      created_at: '',
    });
  
    const handleInputChange = (e) => {
      const { name, value } = e.target;
      setNewStockEntry((prev) => ({
        ...prev,
        [name]: value,
      }));
    };
  
    const addStockEntry = () => {
      if (newStockEntry.productId && newStockEntry.quantity > 0 && newStockEntry.supplier) {
        setStockEntries((prev) => [
          ...prev,
          { ...newStockEntry, id: prev.length + 1 },
        ]);
  
        // Update product stock quantity automatically
        setProductList((prevProducts) =>
          prevProducts.map((product) =>
            product.id === parseInt(newStockEntry.productId)
              ? { ...product, stock: product.stock + parseInt(newStockEntry.quantity) }
              : product
          )
        );
  
        setNewStockEntry({
          productId: '',
          supplier: '',
          quantity: 0,
          created_at: '',
        });
      } else {
        alert('Please fill in all required fields with valid data.');
      }
    };
  
    return (
      <div className="container">
        <h2>Stock Management</h2>
        <div className="row">
          <div className="col-md-6 offset-md-3">
            <div className="form-group">
              <label htmlFor="productId">Product</label>
              <select
                name="productId"
                value={newStockEntry.productId}
                onChange={handleInputChange}
                className="form-control"
                id="productId"
              >
                <option value="">Select Product</option>
                {productList.map((product) => (
                  <option key={product.id} value={product.id}>
                    {product.name}
                  </option>
                ))}
              </select>
            </div>
            <div className="form-group">
              <label htmlFor="supplier">Supplier</label>
              <input
                type="text"
                name="supplier"
                value={newStockEntry.supplier}
                onChange={handleInputChange}
                className="form-control"
                id="supplier"
                placeholder="Supplier Name"
              />
            </div>
            <div className="form-group">
              <label htmlFor="quantity">Quantity</label>
              <input
                type="number"
                name="quantity"
                value={newStockEntry.quantity}
                onChange={handleInputChange}
                className="form-control"
                id="quantity"
                placeholder="Quantity"
              />
            </div>
            <div className="form-group">
              <label htmlFor="created_at">Date</label>
              <input
                type="date"
                name="created_at"
                value={newStockEntry.created_at}
                onChange={handleInputChange}
                className="form-control"
                id="created_at"
              />
            </div>
            <button className="btn btn-primary" onClick={addStockEntry}>
              Add Stock Entry
            </button>
          </div>
        </div>
  
        {/* Stock Entries Table */}
        <div className="table-responsive mt-5">
          <table className="table table-hover">
            <thead>
              <tr>
                <th>Entry ID</th>
                <th>Date</th>
                <th>Supplier</th>
                <th>Product</th>
                <th>Quantity</th>
              </tr>
            </thead>
            <tbody>
              {stockEntries.map((entry) => (
                <tr key={entry.id}>
                  <td>{entry.id}</td>
                  <td>{entry.created_at}</td>
                  <td>{entry.supplier}</td>
                  <td>
                    {productList.find((product) => product.id === parseInt(entry.productId))?.name}
                  </td>
                  <td>{entry.quantity}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
    
   
    function ReportsPage({ productList, ordersList, customersList }) {
      const lowStockProducts = productList.filter(product => product.stock < 10);
    
      const customerPurchaseHistory = customersList.map(customer => {
        const customerOrders = ordersList.filter(order => order.customer === customer.name);
        const totalSpent = customerOrders.reduce((sum, order) => sum + order.total, 0);
        return {
          ...customer,
          totalOrders: customerOrders.length,
          totalSpent,
        };
      });
    
      const totalRevenue = ordersList.reduce((acc, order) => acc + order.total, 0);
    
      return (
        <div className="container">
          <h2>Reports</h2>
          <div className="mb-4">
            <h4>Low Stock Products (Less than 10 units)</h4>
            <table className="table table-hover">
              <thead>
                <tr>
                  <th>Product ID</th>
                  <th>Name</th>
                  <th>Stock</th>
                </tr>
              </thead>
              <tbody>
                {lowStockProducts.map(product => (
                  <tr key={product.id}>
                    <td>{product.id}</td>
                    <td>{product.name}</td>
                    <td>{product.stock}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <div className="mb-4">
            <h4>Customer Purchase History</h4>
            <table className="table table-hover">
              <thead>
                <tr>
                  <th>Customer ID</th>
                  <th>Name</th>
                  <th>Total Orders</th>
                  <th>Total Spent</th>
                </tr>
              </thead>
              <tbody>
                {customerPurchaseHistory.map(customer => (
                  <tr key={customer.id}>
                    <td>{customer.id}</td>
                    <td>{customer.name}</td>
                    <td>{customer.totalOrders}</td>
                    <td>{customer.totalSpent}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
          <div className="mb-4">
            <h4>Total Revenue</h4>
            <p>Total Revenue: ${totalRevenue}</p>
          </div>
          <div className="mb-4">
            <h4>Export Reports</h4>
            <button className="btn btn-secondary me-2">Export Low Stock Report (PDF)</button>
            <button className="btn btn-secondary">Export Revenue Report (Excel)</button>
          </div>
        </div>
      );
    }

    function App() {
      const [categoryList, setCategoryList] = useState([]);
      const [userList, setUserList] = useState([]);
      const [productList, setProductList] = useState([]);
      const [ordersList, setOrdersList] = useState([]);
      const [orderItemsList, setOrderItemsList] = useState([]);
      const [customersList, setCustomersList] = useState([]);
      const [stockEntries, setStockEntries] = useState([]);
      const [paymentsList, setPaymentsList] = useState([]);
      const [newUser, setNewUser] = useState({
        username: '',
        password: '',
        email: '',
        phone: '',
        address: '',
        role: 'customer',
        created_at: ''
      });
      const [newProduct, setNewProduct] = useState({
        name: '',
        description: '',
        price: '',
        stock: '',
        category: '',
        image_url: '',
        status: 'active',
        created_at: ''
      });
      const [newCategory, setNewCategory] = useState({
        name: '',
        description: ''
      });
      const [newPayment, setNewPayment] = useState({
        order_id: '',
        payment_method: 'credit_card',
        payment_status: 'pending',
        created_at: ''
      });
    
      const handleInputChange = (e) => {
        const { name, value } = e.target;
        if (name in newUser) {
          setNewUser((prev) => ({
            ...prev,
            [name]: value
          }));
        } else if (name in newProduct) {
          setNewProduct((prev) => ({
            ...prev,
            [name]: value
          }));
        }
      };
    
      const addUser = () => {
        if (newUser.username && newUser.email) {
          setUserList((prev) => [...prev, { ...newUser, id: prev.length + 1 }]);
          setNewUser({
            username: '',
            password: '',
            email: '',
            phone: '',
            address: '',
            role: 'customer',
            created_at: ''
          });
        } else {
          alert('Please fill in the required fields');
        }
      };
    
      const addProduct = () => {
        if (newProduct.name && newProduct.price) {
          setProductList((prev) => [...prev, { ...newProduct, id: prev.length + 1 }]);
          setNewProduct({
            name: '',
            description: '',
            price: '',
            stock: '',
            category: '',
            image_url: '',
            status: 'active',
            created_at: ''
          });
        } else {
          alert('Please fill in the required fields');
        }
      };
    
      const addPayment = () => {
        if (newPayment.order_id && newPayment.payment_method) {
          setPaymentsList((prev) => [...prev, { ...newPayment, id: prev.length + 1 }]);
          setNewPayment({
            order_id: '',
            payment_method: 'credit_card',
            payment_status: 'pending',
            created_at: ''
          });
        } else {
          alert('Please fill in the required fields');
        }
      };
    
      // Toggle product status (active/hidden)
      const toggleProductStatus = (id) => {
        setProductList(prevProductList =>
          prevProductList.map(product =>
            product.id === id
              ? { ...product, status: product.status === 'active' ? 'hidden' : 'active' }
              : product
          )
        );
      };
    
      // Edit product (update product details)
      const editProduct = (id, updatedProduct) => {
        setProductList(prevList =>
          prevList.map(product =>
            product.id === id ? { ...product, ...updatedProduct } : product
          )
        );
      };
    
      // Delete product
      const deleteProduct = (id) => {
        setProductList(prevList => prevList.filter(product => product.id !== id));
      };
    
      return (
        <Router>
          <div className="App">
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
              <div className="container-fluid">
                <Link className="navbar-brand" to="/">
                  <FontAwesomeIcon icon={faHome} /> Dashboard
                </Link>
                <div className="collapse navbar-collapse" id="navbarNav">
                  <ul className="navbar-nav">
                    <li className="nav-item">
                      <Link className="nav-link" to="/users">
                        <FontAwesomeIcon icon={faUsers} /> Users
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to="/products">
                        <FontAwesomeIcon icon={faBox} /> Products
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to="/orders">
                        <FontAwesomeIcon icon={faShoppingCart} /> Orders
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to="/customers">
                        <FontAwesomeIcon icon={faUserTie} /> Customers
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to="/stock-management">
                        <FontAwesomeIcon icon={faWarehouse} /> Stock Management
                      </Link>
                    </li>
                    <li className="nav-item">
                      <Link className="nav-link" to="/reports">
                        <FontAwesomeIcon icon={faChartLine} /> Reports
                      </Link>
                    </li>
                  </ul>
                </div>
              </div>
            </nav>
            <div className="container my-4">
              <h2>Category Management</h2>
              <div className="mb-3">
                <label>Category Name</label>
                <input
                  type="text"
                  name="name"
                  value={newCategory.name}
                  onChange={(e) => setNewCategory({ ...newCategory, name: e.target.value })}
                  className="form-control mb-2"
                  placeholder="Category Name"
                />
                <label>Description</label>
                <textarea
                  name="description"
                  value={newCategory.description}
                  onChange={(e) => setNewCategory({ ...newCategory, description: e.target.value })}
                  className="form-control mb-2"
                  placeholder="Category Description"
                />
                <button
                  className="btn btn-primary"
                  onClick={() => {
                    if (newCategory.name) {
                      setCategoryList((prev) => [...prev, { ...newCategory, id: prev.length + 1 }]);
                      setNewCategory({ name: '', description: '' });
                    } else {
                      alert('Please fill in the required fields.');
                    }
                  }}
                >
                  Add Category
                </button>
              </div>
              <table className="table table-hover">
                <thead>
                  <tr>
                    <th>Category ID</th>
                    <th>Name</th>
                    <th>Description</th>
                  </tr>
                </thead>
                <tbody>
                  {categoryList.map((category) => (
                    <tr key={category.id}>
                      <td>{category.id}</td>
                      <td>{category.name}</td>
                      <td>{category.description}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
            <Routes>
              <Route path="/" element={<Dashboard userList={userList} productList={productList} categoryList={categoryList} />} />
              <Route path="/users" element={<UserPage userList={userList} setUserList={setUserList} newUser={newUser} setNewUser={setNewUser} handleInputChange={handleInputChange} addUser={addUser} editUser={() => {}} deleteUser={() => {}} />} />
              <Route
                path="/products"
                element={
                  <ProductPage
                    productList={productList}
                    setProductList={setProductList}
                    newProduct={newProduct}
                    setNewProduct={setNewProduct}
                    handleInputChange={handleInputChange}
                    addProduct={addProduct}
                    toggleProductStatus={toggleProductStatus}
                    editProduct={editProduct}  // Truyền editProduct
                    deleteProduct={deleteProduct}  // Truyền deleteProduct
                  />
                }
              />
              <Route path="/orders" element={<OrdersPage ordersList={ordersList} setOrdersList={setOrdersList} productList={productList} orderItemsList={orderItemsList} />} />
              <Route path="/customers" element={<CustomersPage customersList={customersList} setCustomersList={setCustomersList} />} />
              <Route path="/stock-management" element={<StockManagementPage stockEntries={stockEntries} setStockEntries={setStockEntries} productList={productList} setProductList={setProductList} />} />
              <Route path="/reports" element={<ReportsPage productList={productList} ordersList={ordersList} customersList={customersList} />} />
            </Routes>
          </div>
        </Router>
      );
    }
    
    export default App;