import { Injectable, signal } from '@angular/core'; import { HttpClient } from '@angular/common/http'; import { tap } from 'rxjs';
export interface AuthResponse{token:string;name:string;email:string}
@Injectable({providedIn:'root'}) export class AuthService{private api='http://localhost:8080/api'; user=signal<AuthResponse|null>(JSON.parse(localStorage.getItem('pp_user')||'null')); constructor(private http:HttpClient){}
 login(data:any){return this.http.post<AuthResponse>(`${this.api}/auth/login`,data).pipe(tap(r=>{localStorage.setItem('pp_token',r.token);localStorage.setItem('pp_user',JSON.stringify(r));this.user.set(r)}))}
 register(data:any){return this.http.post<AuthResponse>(`${this.api}/auth/register`,data).pipe(tap(r=>{localStorage.setItem('pp_token',r.token);localStorage.setItem('pp_user',JSON.stringify(r));this.user.set(r)}))}
 logout(){localStorage.removeItem('pp_token');localStorage.removeItem('pp_user');this.user.set(null)} isLoggedIn(){return !!localStorage.getItem('pp_token')}}
