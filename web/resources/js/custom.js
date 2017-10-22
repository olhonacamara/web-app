// Esconde o título do projeto no topo da página ao rolar
// a página pra baixo.
$(window).scroll(function() {
    if ($(document).scrollTop() > 1) {
        $('.title-project').addClass('hidden');
    } else {
        $('.title-project').removeClass('hidden');
    }
});