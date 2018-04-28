<footer>
    Copyright: Savytskiy
</footer>

</body>

<script >
    (function checkContent() {
        let footer = document.getElementsByTagName('footer');

        if (window.innerHeight >= document.documentElement.scrollHeight) {
            footer[0].classList.add('footerAbsolute');

        } else {
            footer[0].classList.remove('footerAbsolute');
        }

    })();
</script>
</html>