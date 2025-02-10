/** question_detail */
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

/** question_list */
const page_elemets = document.getElementsByClassName("page-link");
Array.from(page_elemets).forEach((e) => {
	e.addEventListener("click", function() {
		document.getElementById("page").value = this.dataset.page;
		document.getElementById("searchForm").submit();
			
	})
})

const btn_search = document.getElementById("btn_search");
btn_search.addEventListener("click", function() {
	document.getElementById("kw").value = document.getElementById("search_kw").value;
	document.getElementById("page").value = 0;
	document.getElementById("searchForm").submit();
})