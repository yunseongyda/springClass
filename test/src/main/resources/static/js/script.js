const delete_elements = document.getElementById("deletePost");
delete_elements.addEventListener("click", (e) => {
	if (confirm("Delete post?")) {
		location.href=e.target.dataset.uri;
	}
})