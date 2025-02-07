const delete_post = document.getElementById("deletePost");
delete_post.addEventListener("click", (e) => {
	if (confirm("Delete post?")) {
		location.href=e.target.dataset.uri;
	}
})

const delete_answer = document.getElementById("deleteAnswer");
delete_answer.addEventListener("click", (e) => {
	if (confirm("Delete answer?")) {
		location.href=e.target.dataset.uri;
	}
})