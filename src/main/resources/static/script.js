function showContent(section) {
    var content = document.getElementById('mainContent');
    if (!content) return;

    content.style.opacity = 0;
    setTimeout(function() {
        let sectionContent = {
            'orders': '<h2>Orders</h2><p>Here you can view and manage orders.</p>',
            'stock': '<h2>Stock</h2><p>This section shows current stock levels and inventory details.</p>',
            'output': '<h2>Output</h2><p>Review the production output and performance metrics here.</p>',
            'maintenance': '<h2>Maintenance</h2><p>Access the maintenance schedules and reports for equipment.</p>',
            'reports': '<h2>Reports</h2><p>Generate and review various operational reports.</p>',
        };

        content.innerHTML = sectionContent[section] || '<h2>Welcome</h2><p>Select an option from the sidebar to view details.</p>';
        content.style.opacity = 1;
    }, 300);
}

function setTheme(theme) {
    let themes = {
        'blue': {
            '--primary-color': '#357ab7',
            '--secondary-color': '#4fa4e4',
            '--sidebar-bg-start': '#AEDFF7',
            '--sidebar-bg-end': '#B9E6FF',
            '--login-gradient-start': '#4fa4e4',
            '--login-gradient-end': '#357ab7',
            '--button-gradient-start': '#3a8ecb',
            '--button-gradient-end': '#2a6eaa',
            '--page-bg': 'linear-gradient(to bottom right, #f0f8ff, #e0efff)',
            '--theme-btn-bg': '#fff',
            '--theme-btn-text': '#357ab7',
        },
        'green': {
            '--primary-color': '#2d6a4f',
            '--secondary-color': '#52b788',
            '--sidebar-bg-start': '#B7E4C7',
            '--sidebar-bg-end': '#95D5B2',
            '--login-gradient-start': '#52b788',
            '--login-gradient-end': '#2d6a4f',
            '--button-gradient-start': '#40916c',
            '--button-gradient-end': '#1b4332',
            '--page-bg': 'linear-gradient(to bottom right, #f0fff0, #e0ffe0)',
            '--theme-btn-bg': '#fff',
            '--theme-btn-text': '#2d6a4f',
        },
        'dark': {
            '--primary-color': '#f0f0f0',
            '--secondary-color': '#b0b0b0',
            '--sidebar-bg-start': '#2c2c2c',
            '--sidebar-bg-end': '#1c1c1c',
            '--login-gradient-start': '#3d3d3d',
            '--login-gradient-end': '#1c1c1c',
            '--button-gradient-start': '#555555',
            '--button-gradient-end': '#333333',
            '--page-bg': 'linear-gradient(to bottom right, #121212, #1c1c1c)',
            '--theme-btn-bg': '#444444',
            '--theme-btn-text': '#f0f0f0',
        }
    };

    if (themes[theme]) {
        Object.keys(themes[theme]).forEach(key => {
            document.documentElement.style.setProperty(key, themes[theme][key]);
        });
    }
}

// Modal Functions
document.addEventListener("DOMContentLoaded", function() {
    var orderModal = document.getElementById("orderModal");
    if (!orderModal) return;

    // Open modal
    window.openModal = function() {
        orderModal.style.display = "flex";
    };

    // Close modal
    window.closeModal = function() {
        orderModal.style.display = "none";
    };

    // Close modal when clicking outside of it
    window.onclick = function(event) {
        if (event.target === orderModal) {
            closeModal();
        }
    };

    // Form Submission
    var orderForm = document.querySelector("#orderModal form");
    if (orderForm) {
        orderForm.addEventListener("submit", function(event) {
            event.preventDefault(); // Prevent default form submission
            fetch(orderForm.action, {
                method: "POST",
                body: new FormData(orderForm),
            }).then(response => {
                if (response.ok) {
                    closeModal(); // Close modal on success
                    location.reload(); // Reload orders page
                }
            }).catch(error => console.error("Error submitting order:", error));
        });
    }
});
