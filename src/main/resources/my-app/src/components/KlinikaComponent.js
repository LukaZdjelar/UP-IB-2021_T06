import userEvent from '@testing-library/user-event';
import React, { useEffect, useState } from 'react'
import KlinikaServis from '../services/KlinikaService';
import axios from 'axios';
import PacijentHeader from './PacijentHeader';

function  KlinikaComponent () {

    const [search, setSearch] = useState({
        pocetniDatum: undefined,
        krajnjiDatum: undefined,
        lokacija:"",
        ocena:0
    });
    

    const [klinike, setKlinike] = useState([]);

   const handleChange =  (event) => {
        if (event.target.name == "pocetniDatum"){
            setSearch({...search, pocetniDatum:event.target.value})
        }else if(event.target.name == "krajnjiDatum"){
            setSearch({...search,krajnjiDatum:event.target.value})
        }else if(event.target.name == "lokacija"){
            setSearch({...search,lokacija:event.target.value})
        }else if(event.target.name == "ocena"){
            setSearch({...search,ocena:event.target.value})
        }

    }

    useEffect(() =>{
        KlinikaServis.getKlinike().then((response) => {
            setKlinike(response.data)
        });
    },[])

    const submitSearch = ()=>{
        let url = `domZdravlja/klinika?`;
        if(search.pocetniDatum && search.pocetniDatum !== '') {
            url = `${url}pocetniDatum=${search.pocetniDatum}`;
        }
        if(search.krajnjiDatum && search.krajnjiDatum !== '') {
            url = `${url}&krajnjiDatum=${search.krajnjiDatum}`;
        }
        if(search.lokacija && search.lokacija !== ''){
            url = `${url}&lokacija=${search.lokacija}`;
        }
        if(search.ocena) {
            url = `${url}ocena=${search.ocena}`;
        }
        axios.get(url).then(response=>{
            setKlinike(response.data);
        })
    }

        return (
            <div className='klinika'>
                <div>
                    <PacijentHeader/>
                </div>
                
                <h2 id='sort'>Sortiranje</h2>
                <div className='sortiranje'>
                <div className='opcija'>
                    <p>Pocetni datum:</p>
                    <input type = "date" name= "pocetniDatum" onChange ={handleChange} />
                </div>
                <div className='opcija'>
                    <p>Krajnji datum:</p>
                    <input type = "date" name= "krajnjiDatum" onChange ={handleChange}/>
                </div>
                <div className='opcija'>
                    <p>Lokacija:</p>
                    <input placeholder='Unesite lokaciju' type = "text" name="lokacija" onChange ={handleChange}/>
                </div>
                <div className='opcija'>
                    <p>Ocena:</p>
                    <input placeholder='Unesite ocenu' type = "number" min="1" max="5" name ="ocena" onChange ={handleChange}/>
                </div>
                <div className='opcija'>
                    <button onClick={submitSearch} id='btnSort'>Sortiraj</button>
                </div>
                </div>
                <h1>Lista svih klinika</h1>
                <table>
                    <thead>
                        <tr>
                            <td>Naziv</td>
                            <td>Opis</td>
                            <td>Ocena</td>
                            <td>Ulica</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            klinike.map (
                                klinika => 
                                <tr key = {klinika.id}>
                                    <a href={`/doktor/${klinika.id}`} onClick={()=>{localStorage.setItem("klinika",klinika.id)}}><td>{klinika.naziv}</td></a>
                                    <td>{klinika.opis}</td>
                                    <td>{klinika.ocena}</td>
                                    <td>{klinika.adresa?.ulica}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
        
}
export default KlinikaComponent;