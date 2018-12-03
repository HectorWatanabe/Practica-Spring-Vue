const appNote = new Vue({
    el: '#appNote',
    data: {
        notes: [],
        newTitle: '',
        newDescription: ''
    },
    created: function(){
        this.getAllNotes();
    },
    methods: {
        getAllNotes: function(){
            var url = 'notes';
            axios.get(url).then((response) => {
                this.notes = response.data
            });
        },
        createNote: function(){
            var url = "notes/store";
            axios.post(url, {
                title: this.newTitle,
                description: this.newDescription
            }).then( response => {
                this.getAllNotes(),
                this.newTitle = '';
                this.newDescription = '';
                toastr.success('Se registró la nota');
            }).catch(error => {
                toastr.error('Error en los datos');
            });
        }
    }
});