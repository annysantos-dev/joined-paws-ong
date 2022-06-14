import type { NextPage } from 'next'
import Title from '../ui/components/Title/Title'
import List from '../ui/components/List/List'
import { Dialog, TextField, Grid, DialogActions, Button, Snackbar } from '@mui/material'
import { useIndex } from '../data/hooks/pages/useIndex'

const Home: NextPage = () => {
  const {
    listPets,
    petSelected,
    setPetSelected,
    email,
    setEmail,
    value,
    setValue,
    text,
    setMessage,
    toAdopt
  } = useIndex();
  
  return (
    <div>
      <Title 
        title="" 
        caption={
          <span>
            Com um pequeno valor mensal, você <br/>
            pode <strong>adotar um pet virtualmente</strong>
          </span>
        }/>
        <List
          pets={listPets}
          onSelect={(pet) => setPetSelected(pet)}
        />

        <Dialog 
          open={petSelected != null}
          fullWidth
          PaperProps={{ sx:{ p: 5 } }}
          onClose={() => setPetSelected(null)}
        >
          <Grid container spacing={2}>
            <Grid item xs={12}>
              <TextField 
                label={'E-mail'} 
                type={'email'} 
                fullWidth
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              /> 
            </Grid>
            <Grid item xs={12}>
              <TextField 
                label={'Qual sua renda mensal?'} 
                type={'number'} 
                fullWidth
                value={value}
                onChange={(e) => setValue(e.target.value)}
              /> 
            </Grid>
          </Grid>
          <DialogActions sx={{ mt: 5 }}>
              <Button color='secondary' onClick={() => setPetSelected(null)}>Cancelar</Button>
              <Button variant='contained' onClick={toAdopt}>Solicitar adoção</Button>
          </DialogActions>
        </Dialog>

        <Snackbar
          open={text.length > 0}
          message={text}
          autoHideDuration={2500}
          onClose={() => setMessage('')}
        />
          
    </div>
  )
}

export default Home