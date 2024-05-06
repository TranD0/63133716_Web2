var sidebarOpen = false;

    function toggleNav() {
        if (sidebarOpen) {
            closeNav();
        } else {
            openNav();
        }
    }

    function openNav() {
        document.getElementById("mySidebar").style.width = "250px";
        document.getElementById("main").style.marginLeft = "250px";
        sidebarOpen = true;
    }

    function closeNav() {
        document.getElementById("mySidebar").style.width = "0";
        document.getElementById("main").style.marginLeft = "40px";
        sidebarOpen = false;
    }
    function showUserInfo() {
        document.getElementById("user-info").classList.add("active");
    }
    
    function hideUserInfo() {
        document.getElementById("user-info").classList.remove("active");
    }